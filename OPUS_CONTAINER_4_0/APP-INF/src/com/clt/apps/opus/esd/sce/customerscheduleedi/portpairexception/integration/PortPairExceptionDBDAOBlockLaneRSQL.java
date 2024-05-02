/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOBlockLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.30 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOBlockLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOBlockLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOBlockLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("BLK.SLAN_CD," ).append("\n"); 
		query.append("LAN.VSL_SLAN_NM," ).append("\n"); 
		query.append("'' CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POD_CD," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' GUBUN" ).append("\n"); 
		query.append("#if (${gubun} == 'A')" ).append("\n"); 
		query.append(",BLK.ROUT_RCV_DT" ).append("\n"); 
		query.append(",BLK.ROUT_SEQ" ).append("\n"); 
		query.append(",BLK.BLCK_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM SCE_CUST_EDI_BLCK BLK, MDM_VSL_SVC_LANE LAN" ).append("\n"); 
		query.append("#if (${gubun} == 'A')" ).append("\n"); 
		query.append("WHERE BLK.SLAN_CD = LAN.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND BLK.ROUT_RCV_DT = @[rout_rcv_dt]" ).append("\n"); 
		query.append("AND BLK.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND BLK.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",SCE_PORT_PAIR_DTL SPR" ).append("\n"); 
		query.append("WHERE SPR.ROUT_RCV_DT = BLK.ROUT_RCV_DT" ).append("\n"); 
		query.append("AND SPR.ROUT_SEQ = BLK.ROUT_SEQ" ).append("\n"); 
		query.append("AND BLK.SLAN_CD = LAN.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND SPR.CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND SPR.ORG_LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND SPR.DEST_LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND BLK.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}