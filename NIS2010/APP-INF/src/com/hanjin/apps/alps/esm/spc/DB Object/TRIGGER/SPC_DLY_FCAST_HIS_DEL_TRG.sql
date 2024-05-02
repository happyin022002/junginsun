CREATE OR REPLACE TRIGGER NISADM.SPC_DLY_FCAST_HIS_DEL_TRG 
 
before insert or delete or update on SPC_DLY_FCAST_HIS  
for each row

/*
  1.Name       : SPC_DLY_FCAST_HIS_DEL_TRG
  2.Create Date: 2007-12-07
  3.Description:
      - 용도: Daily Forecast 변경 정보의 History 정보를 EDW에 전달하기위한 관리
  4.Revision History
    2007-12-07 : 서관영 최초생성.
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : USA_BKG_MOD_CD,DEST_LOC_CDD 추가
*/

DECLARE V_USER VARCHAR2(50);
begin
        V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
  
  
if( deleting )  then  
        IF V_USER != 'ILMAPPL' THEN
INSERT INTO SPC_DLY_FCAST_HIS_TRC  
    (FCAST_TP_CD,OFC_KND_CD,RLANE_CD,DIR_CD,VSL_CD,SKD_VOY_NO,  
    SKD_DIR_CD,SLS_OFC_CD,POL_YD_CD,POD_YD_CD,BSE_DT,IOC_TS_CD,USA_BKG_MOD_CD,DEST_LOC_CD,UPD_DT)  
VALUES  
( :old.FCAST_TP_CD,:old.OFC_KND_CD,:old.RLANE_CD,:old.DIR_CD,:old.VSL_CD,:old.SKD_VOY_NO,  
 :old.SKD_DIR_CD,:old.SLS_OFC_CD,:old.POL_YD_CD,:old.POD_YD_CD,:old.BSE_DT,:old.IOC_TS_CD,:old.USA_BKG_MOD_CD,:old.DEST_LOC_CD,SYSDATE ) ;  
        end if;
   elsif( inserting ) OR ( updating ) then  
             :new.upd_dt := sysdate;  
   end if;  
  
end;