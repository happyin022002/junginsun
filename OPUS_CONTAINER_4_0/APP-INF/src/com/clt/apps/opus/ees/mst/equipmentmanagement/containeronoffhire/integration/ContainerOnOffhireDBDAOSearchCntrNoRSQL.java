/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.08.07 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr No를 조회하여 데이타 추출
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrNoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MC.CNTR_NO		AS CNTR_NO" ).append("\n"); 
		query.append("	,MC.ONH_YD_CD	AS ONH_YD_CD" ).append("\n"); 
		query.append("	,MC.CNTR_STS_CD AS CNTR_STS_CD" ).append("\n"); 
		query.append("	,MC.LOT_PLN_YR	AS LOT_PLN_YR" ).append("\n"); 
		query.append("	,MC.CNMV_STS_CD	AS CNMV_STS_CD " ).append("\n"); 
		query.append("FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE MC.LOT_PLN_YR   = @[lot_pln_yr]" ).append("\n"); 
		query.append("AND   MC.LOT_LOC_CD   = @[lot_loc_cd]" ).append("\n"); 
		query.append("AND   MC.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND   MC.LOT_SEQ      = @[lot_seq]" ).append("\n"); 

	}
}