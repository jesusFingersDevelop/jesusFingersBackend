import {
  Entity,
  Column,
  PrimaryGeneratedColumn,
  CreateDateColumn,
  UpdateDateColumn,
  OneToMany,
  DeleteDateColumn,
  PrimaryColumn,
} from 'typeorm';

@Entity()
export class Users {
  @PrimaryGeneratedColumn('uuid')
  userId: string;

  @PrimaryColumn()
  kakaoId: string;

  @Column()
  userEmail: string;

  @Column({ type: 'varchar', length: 20 })
  userProvider: string;

  @Column({ type: 'boolean', default: false })
  userPrivacy: boolean;

  @Column({ type: 'varchar', nullable: true })
  userRefreshToken: string;

  @DeleteDateColumn({ type: 'timestamp' })
  deletedAt: Date;

  @CreateDateColumn({ type: 'timestamp' })
  createdAt: Date;

  @UpdateDateColumn({ type: 'timestamp' })
  updatedAt: Date;

  // @OneToMany(() => reservation,)
}
