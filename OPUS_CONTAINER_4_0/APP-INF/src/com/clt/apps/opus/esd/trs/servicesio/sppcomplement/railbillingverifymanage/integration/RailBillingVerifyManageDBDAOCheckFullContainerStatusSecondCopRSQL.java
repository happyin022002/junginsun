/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP에서 더미 CNTR 정보를 조회
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqTpSzCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondCopRSQL").append("\n"); 
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
		query.append("    G.COP_NO||G.COST_ACT_GRP_SEQ CNTR_NO," ).append("\n"); 
		query.append("    H.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    H.COP_NO COP_NO," ).append("\n"); 
		query.append("    G.COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("    'IT''S NOGOOD' NOGOOD," ).append("\n"); 
		query.append("    H.BKG_NO BKG_NO," ).append("\n"); 
		query.append("    H.CNTR_NO CNTR_NO_ORIGIN" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    SCE_COP_HDR H," ).append("\n"); 
		query.append("    SCE_PLN_SO_LIST G" ).append("\n"); 
		query.append("WHERE H.COP_NO = G.COP_NO" ).append("\n"); 
		query.append("AND   H.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("AND   DECODE (H.MST_COP_NO, H.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("AND   G.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   G.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND   SUBSTR(G.COST_ACT_GRP_CD , 1,1) = 'O'" ).append("\n"); 
		query.append("AND   H.CNTR_NO = 'COMU0000000'" ).append("\n"); 
		query.append("AND   H.BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("AND   DECODE(H.CNTR_TPSZ_CD, 'D4', 'D45', 'D5', 'D45', H.CNTR_TPSZ_CD)= @[eqTpSzCd]" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    H.COP_NO ASC" ).append("\n"); 

	}
}