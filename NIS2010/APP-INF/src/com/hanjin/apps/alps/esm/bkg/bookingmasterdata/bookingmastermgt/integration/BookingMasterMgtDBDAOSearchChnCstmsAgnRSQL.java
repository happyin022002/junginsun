/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchChnCstmsAgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.15 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchChnCstmsAgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chinese EDI Agent 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchChnCstmsAgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchChnCstmsAgnRSQL").append("\n"); 
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
		query.append("SELECT AGN_CTRL_OFC_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       CHN_CSTMS_AGN_CD," ).append("\n"); 
		query.append("       SLAN_CD," ).append("\n"); 
		query.append("       CHN_CSTMS_AGN_NM," ).append("\n"); 
		query.append("       EDI_RCV_ID," ).append("\n"); 
		query.append("       EDI_SND_ID," ).append("\n"); 
		query.append("       CHN_CSTMS_AGN_RMK," ).append("\n"); 
		query.append("	   CHN_CSTMS_AGN_FULL_NM  ," ).append("\n"); 
		query.append("	   CHN_CSTMS_AGN_PIC_NM   ," ).append("\n"); 
		query.append("	   CHN_CSTMS_AGN_PHN_NO   ," ).append("\n"); 
		query.append("	   CHN_CSTMS_AGN_EML      ," ).append("\n"); 
		query.append("	   CHN_CSTMS_AGN_ADDR     ," ).append("\n"); 
		query.append("       CRE_OFC_CD," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_AGN_STUP" ).append("\n"); 
		query.append("WHERE 1= 1" ).append("\n"); 
		query.append("#if (${agn_ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   AGN_CTRL_OFC_CD = @[agn_ctrl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND   POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chn_cstms_agn_cd} != '') " ).append("\n"); 
		query.append("AND   CHN_CSTMS_AGN_CD = @[chn_cstms_agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND   SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}