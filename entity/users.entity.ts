import {
  Entity,
  Column,
  PrimaryGeneratedColumn,
  CreateDateColumn,
  UpdateDateColumn,
  OneToMany,
  DeleteDateColumn,
} from 'typeorm';

@Entity()
export class User {
  @PrimaryGeneratedColumn('uuid')
  userId: string;

  @Column({
    type: 'varchar',
    length: 100,
    unique: true,
  })
  userProviderId: string;

  @Column({ type: 'smallint', default: 10 })
  userLevel: number;

  @Column({ type: 'varchar', length: 100, default: 'none' })
  userProfileImage: string;

  @Column({ type: 'varchar', length: 30 })
  userNick: string;

  @Column({ type: 'varchar', length: 20 })
  userProvider: string;

  @Column({ type: 'boolean', default: false })
  userPrivacy: boolean;

  @Column({ type: 'varchar', nullable: true })
  userRefreshToken: string;

  @DeleteDateColumn({ type: 'timestamptz' })
  deletedAt: Date;

  @CreateDateColumn({ type: 'timestamptz' })
  createdAt: Date;

  @UpdateDateColumn({ type: 'timestamptz' })
  updatedAt: Date;

  // @OneToMany(() => reservation,)
}
