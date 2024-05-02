/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOmodifyRepairTariffStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.18 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOmodifyRepairTariffStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public TariffMgtDBDAOmodifyRepairTariffStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOmodifyRepairTariffStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_RPR_TRF_HDR" ).append("\n"); 
		query.append("SET MNR_TRF_STS_CD = @[mnr_trf_sts_cd]" ).append("\n"); 
		query.append(", MNR_TRF_RMK	   = @[mnr_trf_rmk]" ).append("\n"); 
		query.append(", MNR_TRF_STS_DT = SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID	   = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT		   = SYSDATE" ).append("\n"); 
		query.append("WHERE TRF_NO		   = @[trf_no]" ).append("\n"); 

	}
}