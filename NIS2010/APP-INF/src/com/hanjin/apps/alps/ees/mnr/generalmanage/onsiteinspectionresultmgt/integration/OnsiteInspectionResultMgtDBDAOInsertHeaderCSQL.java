/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOInsertHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
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

public class OnsiteInspectionResultMgtDBDAOInsertHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 지정한 Yard Code, Vendor Sequence, Inspection Date가 기존에 저장되지 않은 정보일 경우,
	  * Header를 생성하여 초기화를 하여 준다.
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOInsertHeaderCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOInsertHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ONSITE_INSP_RSLT " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("VNDR_SEQ, " ).append("\n"); 
		query.append("YD_CD, " ).append("\n"); 
		query.append("FLD_INSP_DT, " ).append("\n"); 
		query.append("INSP_OFC_CD, " ).append("\n"); 
		query.append("FILE_SEQ, " ).append("\n"); 
		query.append("CRE_USR_ID, " ).append("\n"); 
		query.append("CRE_DT, " ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("BRNC_INSP_FLG," ).append("\n"); 
		query.append("HDBRN_INSP_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("@[yd_cd]," ).append("\n"); 
		query.append("TO_DATE(@[fld_insp_dt], 'YYYY-MM-DD HH:MI:SS'), " ).append("\n"); 
		query.append("@[insp_ofc_cd]," ).append("\n"); 
		query.append("'0'," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}