/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOCheckVvdBdrLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.30 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOCheckVvdBdrLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkVvdBdrLog
	  * </pre>
	  */
	public BookingMasterMgtDBDAOCheckVvdBdrLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOCheckVvdBdrLogRSQL").append("\n"); 
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
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	SELECT DECODE(SIGN(COUNT(1)),1,'Y','N') BDR_FLAG" ).append("\n"); 
		query.append("	FROM BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("	WHERE	1=1" ).append("\n"); 
		query.append("	#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("		AND   VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("		AND   SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND   SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		AND	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("		AND	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rdo_trunk_feeder} =='T')" ).append("\n"); 
		query.append("		AND (TRNK_BDR_FLG = 'Y' OR TRNK_AUTO_BDR_FLG = 'Y' OR TRNK_MNL_BDR_FLG = 'Y')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND (FDR_BDR_FLG = 'Y' OR FDR_AUTO_BDR_FLG = 'Y' OR FDR_MNL_BDR_FLG = 'Y')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 'N' BDR_FLAG FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}