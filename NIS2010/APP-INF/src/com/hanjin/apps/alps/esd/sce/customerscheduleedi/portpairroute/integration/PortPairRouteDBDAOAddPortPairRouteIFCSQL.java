/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDBDAOAddPortPairRouteIFCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.09 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Han Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOAddPortPairRouteIFCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Port Pair Route I/F처리한다
	  * </pre>
	  */
	public PortPairRouteDBDAOAddPortPairRouteIFCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOAddPortPairRouteIFCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CUST_EDI_ROUT_IF(EDI_RCVR_ID" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",VSL_TS_TP_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",N1ST_POL_CD" ).append("\n"); 
		query.append(",N1ST_POD_CD" ).append("\n"); 
		query.append(",N2ND_POL_CD" ).append("\n"); 
		query.append(",N2ND_POD_CD" ).append("\n"); 
		query.append(",N3RD_POL_CD" ).append("\n"); 
		query.append(",N3RD_POD_CD" ).append("\n"); 
		query.append(",N4TH_POL_CD" ).append("\n"); 
		query.append(",N4TH_POD_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES( @[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",@[rout_seq]" ).append("\n"); 
		query.append(",(CASE WHEN @[n4th_pol_cd] IS NOT NULL THEN '3'" ).append("\n"); 
		query.append("WHEN @[n3rd_pol_cd] IS NOT NULL THEN '2'" ).append("\n"); 
		query.append("ELSE '1' END)" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",@[n1st_pol_cd]" ).append("\n"); 
		query.append(",@[n1st_pod_cd]" ).append("\n"); 
		query.append(",@[n2nd_pol_cd]" ).append("\n"); 
		query.append(",@[n2nd_pod_cd]" ).append("\n"); 
		query.append(",@[n3rd_pol_cd]" ).append("\n"); 
		query.append(",@[n3rd_pod_cd]" ).append("\n"); 
		query.append(",@[n4th_pol_cd]" ).append("\n"); 
		query.append(",@[n4th_pod_cd]" ).append("\n"); 
		query.append(",@[delt_flg]" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(", '$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append(", '$usr_id'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}