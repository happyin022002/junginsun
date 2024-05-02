CREATE OR REPLACE TRIGGER NISADM.SPC_ALOC_POL_POD_DEL_TRG
before insert or delete or update on SPC_ALOC_POL_POD
for each row
DECLARE V_USER VARCHAR2(50);
/*
  1.Name       : 김원섭
  2.Create Date: 2006-12-15
  3.Description:
      - 용도: Allocation Delete Key 정보를 EDW에 전달하기위한 관리
  4.Revision History
    2006-12-15:김원섭:최초생성
    2013-03-25:K.S.M   - [Ticket ID : CHM-201322502] Alloc 삭제 시 IOC_CD 정보도 함께 저장되도록 수정
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : CUST_CNT_CD,CUST_SEQ,USA_BKG_MOD_CD,DEST_LOC_CD 추가
    2014-12-10:신자영  - [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세 - CTRT_NO 추가
*/
begin
        V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
if( deleting )  then
        IF V_USER != 'ILMAPPL' THEN
INSERT  INTO SPC_ALOC_POL_POD_TRC    
    ( RLANE_CD  ,DIR_CD , VSL_CD,SKD_VOY_NO,SKD_DIR_CD,SLS_OFC_CD,POL_YD_CD,POD_YD_CD,TS_FLG,MNL_FLG, IOC_CD, CUST_CNT_CD,CUST_SEQ,USA_BKG_MOD_CD,DEST_LOC_CD,upd_dt,CTRT_NO)
VALUES
  ( :old.RLANE_CD  ,:old.DIR_CD , :old.VSL_CD, :old.SKD_VOY_NO, :old.SKD_DIR_CD, :old.SLS_OFC_CD, :old.POL_YD_CD,:old.POD_YD_CD,:old.TS_FLG,:old.MNL_FLG,:old.IOC_CD, :old.CUST_CNT_CD,:old.CUST_SEQ,:old.USA_BKG_MOD_CD,:old.DEST_LOC_CD, sysdate,:old.CTRT_NO);
        end if;
   elsif( inserting ) or ( updating ) then
             :new.upd_dt := sysdate;
   end if;
end;