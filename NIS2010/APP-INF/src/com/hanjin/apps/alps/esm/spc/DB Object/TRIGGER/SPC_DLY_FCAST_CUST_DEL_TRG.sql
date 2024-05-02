CREATE OR REPLACE TRIGGER NISADM.SPC_DLY_FCAST_CUST_DEL_TRG
before insert or delete or update on SPC_DLY_FCAST_CUST
for each row
DECLARE V_USER VARCHAR2(50);
/*
  1.Name       : SPC_DLY_FCAST_CUST_DEL_TRG
  2.Create Date: 
  3.Description:
      - 용도: SPC DAILY FORECAST CUSTOMER TRACE - DW 요건
  4.Revision History
    2013-02-05 : 김수정 [Ticket ID : CHM-201322502] 성수기 선복운영 프로젝트 - FCAST_SEQ PK 추가 및 S/C 추가
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : USA_BKG_MOD_CD,DEST_LOC_CDD 추가
*/
begin
        V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
if( deleting )  then
        IF V_USER != 'ILMAPPL' THEN
INSERT  INTO SPC_DLY_FCAST_CUST_TRC    
    ( RLANE_CD  ,DIR_CD , VSL_CD,SKD_VOY_NO,SKD_DIR_CD,IOC_TS_CD,SREP_USR_ID,CUST_CNT_CD,CUST_SEQ,POL_YD_CD, POD_YD_CD, FCAST_OFC_CD,FCAST_CUST_TP_CD, FCAST_SEQ,USA_BKG_MOD_CD,DEST_LOC_CD, upd_dt)
VALUES
  ( :old.RLANE_CD  ,:old.DIR_CD , :old.VSL_CD,:old.SKD_VOY_NO,:old.SKD_DIR_CD,:old.IOC_TS_CD,:old.SREP_USR_ID,:old.CUST_CNT_CD,:old.CUST_SEQ,:old.POL_YD_CD, :old.POD_YD_CD, :old.FCAST_OFC_CD,:old.FCAST_CUST_TP_CD, :old.FCAST_SEQ,:old.USA_BKG_MOD_CD,:old.DEST_LOC_CD,sysdate);
        end if;
    elsif( inserting ) or ( updating ) then
             :new.upd_dt := sysdate;
   end if;
end;