/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchChnMnlBkgNoGenListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.15 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchChnMnlBkgNoGenListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 북중국 Manual BKG NO 생성 현황 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchChnMnlBkgNoGenListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchChnMnlBkgNoGenListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO, A.CHN_AGN_CD, A.CRE_OFC_CD, A.CRE_USR_ID, " ).append("\n"); 
		query.append("	TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT ," ).append("\n"); 
		query.append("	CASE" ).append("\n"); 
		query.append("	WHEN A.BKG_NO_USE_FLG ='Y' THEN " ).append("\n"); 
		query.append("	(SELECT TO_CHAR(B.BKG_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("	 FROM BKG_BOOKING B" ).append("\n"); 
		query.append("	 WHERE B.BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("	 ELSE NULL" ).append("\n"); 
		query.append("	END AS BKG_CRE_DT, " ).append("\n"); 
		query.append("	A.BKG_NO_USE_FLG" ).append("\n"); 
		query.append("  FROM BKG_CHN_BKG_NO_GEN A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chn_agn_cd} != '')" ).append("\n"); 
		query.append("   AND A.CHN_AGN_CD = @[chn_agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.CRE_DT >= TO_DATE(@[fm_cre_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND A.CRE_DT <  TO_DATE(@[to_cre_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#if (${bkg_no_use_flg} != '%')" ).append("\n"); 
		query.append("   AND A.BKG_NO_USE_FLG = @[bkg_no_use_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}