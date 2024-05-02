/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOmodifyPkupNtcPkupNoByPkupNtcByBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmodifyPkupNtcPkupNoByPkupNtcByBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOmodifyPkupNtcPkupNoByPkupNtcByBkgNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmodifyPkupNtcPkupNoByPkupNtcByBkgNoUSQL").append("\n"); 
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
		query.append("/* 삭제됨!!" ).append("\n"); 
		query.append("UPDATE BKG_PKUP_NTC_PKUP_NO X" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("       (PKUP_NO, PKUP_AVAL_DT, LST_FREE_DT, PKUP_YD_CD, RTN_YD_CD)" ).append("\n"); 
		query.append("       =" ).append("\n"); 
		query.append("       (SELECT PKUP_NO, PKUP_AVAL_DT, LST_FREE_DT, PKUP_YD_CD, RTN_YD_CD      " ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC  A" ).append("\n"); 
		query.append("              ,BKG_BOOKING   B" ).append("\n"); 
		query.append("              ,MDM_LOCATION  C      " ).append("\n"); 
		query.append("         WHERE A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND A.NTC_SEQ = @[ntc_seq]" ).append("\n"); 
		query.append("           AND B.BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("           AND B.DEL_CD  = C.LOC_CD" ).append("\n"); 
		query.append("           AND X.BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("           AND X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND X.OFC_CD  = C.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       ,PKUP_UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("       ,PKUP_UPD_DT     = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(OFC_CD)" ).append("\n"); 
		query.append("       ,UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE  EXISTS" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT A.BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC  A" ).append("\n"); 
		query.append("              ,BKG_BOOKING   B" ).append("\n"); 
		query.append("              ,MDM_LOCATION  C      " ).append("\n"); 
		query.append("         WHERE A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND A.NTC_SEQ = @[ntc_seq]" ).append("\n"); 
		query.append("           AND B.BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("           AND B.DEL_CD  = C.LOC_CD" ).append("\n"); 
		query.append("           AND X.BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("           AND X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND X.OFC_CD  = C.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}