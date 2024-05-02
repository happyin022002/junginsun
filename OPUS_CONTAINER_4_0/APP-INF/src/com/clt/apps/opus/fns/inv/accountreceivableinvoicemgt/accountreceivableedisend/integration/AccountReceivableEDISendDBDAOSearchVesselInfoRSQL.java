/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchVesselInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchVesselInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Vessel Info
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchVesselInfoRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchVesselInfoRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_ENG_NM " ).append("\n"); 
		query.append("	   , B.VSL_CD" ).append("\n"); 
		query.append("       , B.SKD_VOY_NO" ).append("\n"); 
		query.append("       , DECODE(@[io_bnd_cd], 'I', B.IB_CSSM_VOY_NO, 'O', B.OB_CSSM_VOY_NO) CSSM_VOY_NO" ).append("\n"); 
		query.append("	   , A.LLOYD_NO" ).append("\n"); 
		query.append("       , TO_CHAR(B.VPS_ETA_DT, 'YYYY') VOY_YR           -- 추가항목" ).append("\n"); 
		query.append("       , TO_CHAR(B.VPS_ETA_DT, 'YYYYMMDD') FNL_ETA_DT   -- 추가항목" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR A," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND   B.VPS_PORT_CD = DECODE(@[io_bnd_cd], 'I', @[pod_cd], 'O', @[pol_cd])" ).append("\n"); 
		query.append("AND   B.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}