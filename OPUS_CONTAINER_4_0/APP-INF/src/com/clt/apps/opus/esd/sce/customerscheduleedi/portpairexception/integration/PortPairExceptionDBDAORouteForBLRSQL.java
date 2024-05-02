/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAORouteForBLRSQL.java
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

public class PortPairExceptionDBDAORouteForBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAORouteForBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAORouteForBLRSQL").append("\n"); 
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
		query.append("SELECT A.rout_rcv_dt" ).append("\n"); 
		query.append(",A.rout_seq" ).append("\n"); 
		query.append(",A.cust_trd_prnr_id" ).append("\n"); 
		query.append(",A.por_cd" ).append("\n"); 
		query.append(",A.org_loc_cd AS pol_cd" ).append("\n"); 
		query.append(",A.n1st_pol_cd" ).append("\n"); 
		query.append(",A.n1st_pod_cd" ).append("\n"); 
		query.append(",A.n2nd_pol_cd" ).append("\n"); 
		query.append(",A.n2nd_pod_cd" ).append("\n"); 
		query.append(",A.n3rd_pol_cd" ).append("\n"); 
		query.append(",A.n3rd_pod_cd" ).append("\n"); 
		query.append(",A.n4th_pol_cd" ).append("\n"); 
		query.append(",A.n4th_pod_cd" ).append("\n"); 
		query.append(",A.dest_loc_cd AS pod_cd" ).append("\n"); 
		query.append(",A.del_cd" ).append("\n"); 
		query.append(",A.UPD_IND_CD AS ocean_flag" ).append("\n"); 
		query.append(",A.use_flg" ).append("\n"); 
		query.append(",A.mnl_use_flg" ).append("\n"); 
		query.append(",A.cre_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(A.cre_dt, 'YYYYMMDDHH24MI') AS cre_dt" ).append("\n"); 
		query.append(",A.upd_usr_id" ).append("\n"); 
		query.append(",TO_CHAR(A.upd_dt, 'YYYYMMDDHH24MI') AS upd_dt" ).append("\n"); 
		query.append(",val AS BLOCK_LANE" ).append("\n"); 
		query.append(",A.cust_trd_prnr_id" ).append("\n"); 
		query.append(",'' POL_CNT" ).append("\n"); 
		query.append(",'' POD_CNT" ).append("\n"); 
		query.append(",'' POL_CONTI" ).append("\n"); 
		query.append(",'' POD_CONTI" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL A," ).append("\n"); 
		query.append("MDM_LOCATION POL," ).append("\n"); 
		query.append("MDM_LOCATION POD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT substr(xmlagg(xmlelement(a, DECODE(BLK.SLAN_CD, '', '', ',') || BLK.SLAN_CD)" ).append("\n"); 
		query.append("order by BLK.SLAN_CD).extract('//text()'), 2) val," ).append("\n"); 
		query.append("BLK.ROUT_RCV_DT," ).append("\n"); 
		query.append("BLK.ROUT_SEQ" ).append("\n"); 
		query.append("FROM SCE_CUST_EDI_BLCK BLK" ).append("\n"); 
		query.append("WHERE BLK.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("GROUP BY BLK.ROUT_RCV_DT, BLK.ROUT_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.cust_trd_prnr_id = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND A.ORG_LOC_CD = POL.LOC_CD" ).append("\n"); 
		query.append("AND A.DEST_LOC_CD = POD.LOC_CD" ).append("\n"); 
		query.append("AND POL.LOC_CD = NVL(@[pol_cd], POL.LOC_CD)" ).append("\n"); 
		query.append("AND POD.LOC_CD = NVL(@[pod_cd], POD.LOC_CD)" ).append("\n"); 
		query.append("AND POL.CNT_CD = NVL(@[pol_cnt], POL.CNT_CD)" ).append("\n"); 
		query.append("AND POD.CNT_CD = NVL(@[pod_cnt], POD.CNT_CD)" ).append("\n"); 
		query.append("AND POL.CONTI_CD = NVL(@[pol_conti], POL.CONTI_CD)" ).append("\n"); 
		query.append("AND POD.CONTI_CD = NVL(@[pod_conti], POD.CONTI_CD)" ).append("\n"); 
		query.append("AND A.ROUT_RCV_DT = B.ROUT_RCV_DT(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY A.por_cd, A.org_loc_cd, A.n1st_pol_cd, n2nd_pol_cd, A.n3rd_pol_cd, A.n4th_pod_cd, A.upd_dt" ).append("\n"); 

	}
}