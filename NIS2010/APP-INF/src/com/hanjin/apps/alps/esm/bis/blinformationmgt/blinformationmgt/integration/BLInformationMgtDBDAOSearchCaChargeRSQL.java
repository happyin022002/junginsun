/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchCaChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchCaChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchCaChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchCaChargeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("WITH CHG_RT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT OLD.CHG_CD          as OCHG_CD," ).append("\n"); 
		query.append("OLD.RAT_UT_CD        as ORAT_UT_CD," ).append("\n"); 
		query.append("OLD.RAT_AS_QTY       as ORAT_AS_QTY," ).append("\n"); 
		query.append("OLD.CURR_CD          as OCURR_CD," ).append("\n"); 
		query.append("OLD.CHG_UT_AMT       as OCHG_UT_AMT," ).append("\n"); 
		query.append("OLD.CHG_AMT          as OCHG_AMT," ).append("\n"); 
		query.append("OLD.FRT_TERM_CD      as OFRT_TERM_CD," ).append("\n"); 
		query.append("OLD.N3PTY_RCV_OFC_CD as ON3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("NEW.CHG_CD           as NCHG_CD," ).append("\n"); 
		query.append("NEW.RAT_UT_CD        as NRAT_UT_CD," ).append("\n"); 
		query.append("NEW.RAT_AS_QTY       as NRAT_AS_QTY," ).append("\n"); 
		query.append("NEW.CURR_CD          as NCURR_CD," ).append("\n"); 
		query.append("NEW.CHG_UT_AMT       as NCHG_UT_AMT," ).append("\n"); 
		query.append("NEW.CHG_AMT          as NCHG_AMT," ).append("\n"); 
		query.append("NEW.FRT_TERM_CD      as NFRT_TERM_CD," ).append("\n"); 
		query.append("NEW.N3PTY_RCV_OFC_CD as NN3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BKG_NO, CORR_NO, CHG_CD, RT_SEQ, RAT_UT_CD, RAT_AS_QTY,CURR_CD, CHG_UT_AMT, CHG_AMT,FRT_TERM_CD, N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("FROM BIS_CHG_RT_HIS BCRH" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = ( SELECT CORR_NO FROM BIS_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO  = BCRH.BKG_NO" ).append("\n"); 
		query.append("AND CORR_DT = ( SELECT MAX(CORR_DT) FROM BIS_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO = BCRH.BKG_NO" ).append("\n"); 
		query.append("AND CORR_DT < ( SELECT CORR_DT FROM BIS_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO = BCRH.BKG_NO" ).append("\n"); 
		query.append("AND  CORR_NO = @[ca_no] )) )" ).append("\n"); 
		query.append(") OLD FULL OUTER JOIN (" ).append("\n"); 
		query.append("SELECT BKG_NO, CORR_NO, CHG_CD, RT_SEQ, RAT_UT_CD, RAT_AS_QTY,CURR_CD, CHG_UT_AMT, CHG_AMT,FRT_TERM_CD, N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("FROM BIS_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = @[ca_no] ) NEW" ).append("\n"); 
		query.append("ON old.bkg_no = new.bkg_no" ).append("\n"); 
		query.append("AND OLD.RT_SEQ = NEW.RT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'PREVIOUS'                  as CORR_NAME," ).append("\n"); 
		query.append("NVL(OCHG_CD,NCHG_CD)        as CHG_CD," ).append("\n"); 
		query.append("NVL(ORAT_UT_CD,NRAT_UT_CD)  as RAT_UT_CD," ).append("\n"); 
		query.append("TO_CHAR(NVL(ORAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("OCURR_CD                    as CURR_CD," ).append("\n"); 
		query.append("NVL(OCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("NVL(OCHG_AMT,0)             as CHG_AMT," ).append("\n"); 
		query.append("OFRT_TERM_CD                as FRT_TERM_CD," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N', DECODE(OFRT_TERM_CD ,'P', OCHG_AMT, '0'),'0')) as PREPAID," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N', DECODE(OFRT_TERM_CD ,'C', OCHG_AMT, '0'),'0')) as COLLECT," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N','0', OCHG_AMT)) as THIRD" ).append("\n"); 
		query.append("FROM CHG_RT" ).append("\n"); 
		query.append("WHERE NVL(OCHG_CD,' ')      <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_UT_CD,' ')   <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_AS_QTY,0)    <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("OR NVL(OCURR_CD,' ')     <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("OR NVL(OCHG_UT_AMT,0)    <> NVL(NCHG_UT_AMT,0)" ).append("\n"); 
		query.append("OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CURRENT'                   as CORR_NAME," ).append("\n"); 
		query.append("NVL(NCHG_CD,OCHG_CD)        as CHG_CD," ).append("\n"); 
		query.append("NVL(NRAT_UT_CD,ORAT_UT_CD)  as RAT_UT_CD," ).append("\n"); 
		query.append("TO_CHAR(NVL(NRAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("NCURR_CD                    as CURR_CD," ).append("\n"); 
		query.append("NVL(NCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("NVL(NCHG_AMT,0)             as CHG_AMT," ).append("\n"); 
		query.append("NFRT_TERM_CD                as FRT_TERM_CD," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N', DECODE(NFRT_TERM_CD ,'P', NCHG_AMT, '0'),'0')) as PREPAID," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N', DECODE(NFRT_TERM_CD ,'C', NCHG_AMT, '0'),'0')) as COLLECT," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N','0', NCHG_AMT)) as THIRD" ).append("\n"); 
		query.append("FROM CHG_RT" ).append("\n"); 
		query.append("WHERE NVL(OCHG_CD,' ')      <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_UT_CD,' ')   <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_AS_QTY,0)    <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("OR NVL(OCURR_CD,' ')     <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("OR NVL(OCHG_UT_AMT,0)    <> NVL(NCHG_UT_AMT,0)" ).append("\n"); 
		query.append("OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'DIFFERENCE'                                     as CORR_NAME," ).append("\n"); 
		query.append("NVL(NCHG_CD,OCHG_CD)                             as CHG_CD," ).append("\n"); 
		query.append("NVL(NRAT_UT_CD,ORAT_UT_CD)                       as RAT_UT_CD," ).append("\n"); 
		query.append("TO_CHAR(NVL(NRAT_AS_QTY,0) - NVL(ORAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("NVL(NCURR_CD,OCURR_CD)                           as CURR_CD," ).append("\n"); 
		query.append("NVL(NCHG_UT_AMT,0) - NVL(OCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("NVL(NCHG_AMT,0) - NVL(OCHG_AMT,0)                as CHG_AMT," ).append("\n"); 
		query.append("NVL(NFRT_TERM_CD,OFRT_TERM_CD)                   as FRT_TERM_CD," ).append("\n"); 
		query.append("DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'P', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0'))," ).append("\n"); 
		query.append("0, '-'," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'P', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')) )" ).append("\n"); 
		query.append("as PREPAID," ).append("\n"); 
		query.append("DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'C', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0'))," ).append("\n"); 
		query.append("0, '-'," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'C', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')) )" ).append("\n"); 
		query.append("as COLLECT," ).append("\n"); 
		query.append("DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N','0', NCHG_AMT))," ).append("\n"); 
		query.append("0, '-'," ).append("\n"); 
		query.append("TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N','0', NCHG_AMT)) )" ).append("\n"); 
		query.append("as THIRD" ).append("\n"); 
		query.append("FROM CHG_RT" ).append("\n"); 
		query.append("WHERE NVL(OCHG_CD,' ')      <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_UT_CD,' ')   <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("OR NVL(ORAT_AS_QTY,0)    <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("OR NVL(OCURR_CD,' ')     <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("OR NVL(OCHG_UT_AMT,0)    <> NVL(NCHG_UT_AMT,0)" ).append("\n"); 
		query.append("OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 

	}
}