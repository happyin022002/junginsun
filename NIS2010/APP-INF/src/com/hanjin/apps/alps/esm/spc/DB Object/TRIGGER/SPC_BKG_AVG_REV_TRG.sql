CREATE OR REPLACE TRIGGER NISADM.SPC_BKG_AVG_REV_TRG 
before insert or delete or update on SPC_BKG_AVG_REV 
for each row
DECLARE V_USER VARCHAR2(50);
/*
  1.Name       : 김원섭
  2.Create Date: 2006-12-15
  3.Description:
      - 용도: Allocation 변경 정보의 History를 저장한다
  4.Revision History
    2013-04-03:K.S.M   - [Ticket ID : CHM-201322502] 컬럼 추가 저장 되도록 수정
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : BKG_POD_CD,BKG_DEL_CD,USA_BKG_MOD_CD 추가
*/
begin
        V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
 
if( deleting )  then 
        IF V_USER != 'ILMAPPL' THEN
INSERT INTO SPC_BKG_AVG_REV_TRC 
    ( OFC_KND_CD,TRD_CD,RLANE_CD,DIR_CD, SLS_OFC_CD,TS_FLG,POL_YD_CD,POD_YD_CD,IOC_CD,COST_YRWK,CUST_CNT_CD,CUST_SEQ,SLS_RHQ_CD,BKG_POD_CD,BKG_DEL_CD,USA_BKG_MOD_CD,upd_dt) 
VALUES 
( :old.OFC_KND_CD,:old.TRD_CD ,:old.RLANE_CD,:old.DIR_CD, :old.SLS_OFC_CD,:old.TS_FLG,:old.POL_YD_CD,:old.POD_YD_CD,:old.IOC_CD,:old.COST_YRWK,:old.CUST_CNT_CD,:old.CUST_SEQ,:old.SLS_RHQ_CD,:old.BKG_POD_CD,:old.BKG_DEL_CD,:old.USA_BKG_MOD_CD,SYSDATE ) ; 
        end if; 
   elsif(  updating ) then 
             :new.upd_dt := sysdate; 
   end if; 
end;