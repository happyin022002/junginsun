/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOInsertDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAOInsertDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 지정한 Yard Code, Vendor, Inspection Date가 신규일 경우, Initialization을 하여 준다.
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOInsertDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fld_insp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOInsertDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ONSITE_INSP_RSLT_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VNDR_SEQ, " ).append("\n"); 
		query.append("YD_CD, " ).append("\n"); 
		query.append("FLD_INSP_DT, " ).append("\n"); 
		query.append("ONSITE_INSP_RSLT_DTL_SEQ, " ).append("\n"); 
		query.append("EV_ITM_NM, " ).append("\n"); 
		query.append("EV_ITM_ORD_NO, " ).append("\n"); 
		query.append("RSLT_GD_FLG, " ).append("\n"); 
		query.append("RSLT_NORM_FLG, " ).append("\n"); 
		query.append("RSLT_BAD_FLG, " ).append("\n"); 
		query.append("FLD_AUD_RMK, " ).append("\n"); 
		query.append("CRE_USR_ID, " ).append("\n"); 
		query.append("CRE_DT, " ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[vndr_seq], " ).append("\n"); 
		query.append("@[yd_cd], " ).append("\n"); 
		query.append("TO_DATE(@[fld_insp_dt], 'YYYY-MM-DD HH:MI:SS'), " ).append("\n"); 
		query.append("EV_ITM_SEQ, " ).append("\n"); 
		query.append("EV_ITM_NM, " ).append("\n"); 
		query.append("EV_ITM_ORD_NO, " ).append("\n"); 
		query.append("'', " ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("'', " ).append("\n"); 
		query.append("'', " ).append("\n"); 
		query.append("@[usr_id], " ).append("\n"); 
		query.append("sysdate, " ).append("\n"); 
		query.append("@[usr_id], " ).append("\n"); 
		query.append("sysdate " ).append("\n"); 
		query.append("FROM MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 

	}
}