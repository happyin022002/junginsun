/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchVslInfoVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchVslInfoVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO : MxEtaInfoVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchVslInfoVslRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchVslInfoVslRSQL").append("\n"); 
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
		query.append("SELECT 'O' BRAC" ).append("\n"); 
		query.append("	,@[vvd] VVD" ).append("\n"); 
		query.append("	,'' VSL_CALLSIGN" ).append("\n"); 
		query.append("	,'' VSL_LLOYDCODE" ).append("\n"); 
		query.append("	,NVL(D.VSL_ENG_NM, '') VSL_FULLNAME" ).append("\n"); 
		query.append("	,'' LANE_CD" ).append("\n"); 
		query.append("	,'' VVD_REF_NO" ).append("\n"); 
		query.append("	--2009/09/17 " ).append("\n"); 
		query.append("	--PORT와 PORTNAME 상관관계가 맞지 않으나, AS-IS에 구성되어 있는 그대로 사용하기로 함." ).append("\n"); 
		query.append("	,NVL(@[pol_cd], @[pod_cd]) PORT" ).append("\n"); 
		query.append("	,NVL((SELECT LOC_NM" ).append("\n"); 
		query.append("	      FROM MDM_LOCATION" ).append("\n"); 
		query.append("	     WHERE LOC_CD = NVL(@[pod_cd],@[pol_cd])), '') PORTNAME" ).append("\n"); 
		query.append("	,'' ETA" ).append("\n"); 
		query.append("	,'' ETD" ).append("\n"); 
		query.append("	,'' NEXTPORT" ).append("\n"); 
		query.append("	,'' NEXTPORT_ETA" ).append("\n"); 
		query.append("	,'' PREVPORT" ).append("\n"); 
		query.append("	,'' PREVPORT_ETD" ).append("\n"); 
		query.append("	,'CDL' IO_IND" ).append("\n"); 
		query.append("	,'USA' COMP_ID" ).append("\n"); 
		query.append(",NVL(D.CRR_CD,' ') MRN" ).append("\n"); 
		query.append(",NVL(E.CRR_NM,' ') MRN_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR D, MDM_CARRIER E" ).append("\n"); 
		query.append("WHERE D.VSL_CD                   =  SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	AND D.CRR_CD					 =  E.CRR_CD" ).append("\n"); 

	}
}