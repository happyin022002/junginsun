/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddOwnCntrStatusHistorysDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddOwnCntrStatusHistorysDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Own Container 에 대해 S/N Range 만큼 Status History 를 생성한다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddOwnCntrStatusHistorysDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddOwnCntrStatusHistorysDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  CNTR_NO" ).append("\n"); 
		query.append(", CNTR_STS_SEQ" ).append("\n"); 
		query.append(", CO_CD" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", SCC_CD" ).append("\n"); 
		query.append(", LCC_CD" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", RCC_CD" ).append("\n"); 
		query.append(", AGMT_CTY_CD" ).append("\n"); 
		query.append(", AGMT_SEQ" ).append("\n"); 
		query.append(", CNTR_STS_CD" ).append("\n"); 
		query.append(", OFC_CD" ).append("\n"); 
		query.append(", CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(", CNTR_STS_RMK" ).append("\n"); 
		query.append(", CNMV_STS_CD" ).append("\n"); 
		query.append(", CNTR_FULL_FLG" ).append("\n"); 
		query.append(", CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  CNTR_NO" ).append("\n"); 
		query.append(", LST_STS_SEQ	AS CNTR_STS_SEQ" ).append("\n"); 
		query.append(", OWNR_CO_CD	AS CO_CD" ).append("\n"); 
		query.append(", CRNT_YD_CD	AS YD_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", SCC_CD" ).append("\n"); 
		query.append(", LCC_CD" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", RCC_CD" ).append("\n"); 
		query.append(", AGMT_CTY_CD" ).append("\n"); 
		query.append(", AGMT_SEQ" ).append("\n"); 
		query.append(", CNTR_STS_CD" ).append("\n"); 
		query.append(", '1'		AS OFC_CD" ).append("\n"); 
		query.append(", ONH_DT	AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(", CNTR_RMK	AS CNTR_STS_RMK" ).append("\n"); 
		query.append(", CNMV_STS_CD" ).append("\n"); 
		query.append(", FULL_FLG	AS CNTR_FULL_FLG" ).append("\n"); 
		query.append(", '1'		AS CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO BETWEEN SUBSTR(@[fm_ser_no],0,9) AND SUBSTR(@[to_ser_no],4,9);" ).append("\n"); 

	}
}