/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderEurDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderEurDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderEurDtlInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderEurDtlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pin_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("veh_rgst_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("road_hlg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_crr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uq_vsl_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_bdg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderEurDtlInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_EUR_DETAILS'                     || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_BADGECODE:'                 || NVL(@[co_bdg_id],'')             || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_ONCARRIAGE_ID:'  		   || NVL(@[cgo_crr_id],'')            || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_RELEASE_DT:'                || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[rlse_ofc_cd]) ),'YYYYMMDD'),'')   || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_EXPIRY_DT:'                 || NVL(@[rlse_exp_dt],'')		   || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_PIN:'                       || NVL(@[pin_no],'')                			   || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_VEHICLE_ID:'        		   || NVL(@[veh_rgst_id],'')           || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_RHIDS:'                     || NVL(@[road_hlg_id],'')           || CHR(10)" ).append("\n"); 
		query.append("           || 'EUR_UVI:'                       || NVL(@[uq_vsl_id_no],'')          || CHR(10)" ).append("\n"); 
		query.append("           || '}CNTR_EUR_DETAILS'              || CHR(10) " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}