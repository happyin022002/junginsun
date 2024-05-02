/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfCfmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.16 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author DongJin Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfCfmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfCfmInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfCfmInfoRSQL").append("\n"); 
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
		query.append("SELECT A.CFM_USR_ID, TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_CFM A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD     = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND A.PORT_CD      = DECODE( @[bkg_cust_tp_cd], 'S', @[pol_cd], -- OUTBOUND 이면 :polCd" ).append("\n"); 
		query.append("@[pod_cd])   -- INBOUND 이면 :podCd" ).append("\n"); 
		query.append("AND A.WHF_BND_CD   = DECODE( @[bkg_cust_tp_cd], 'S', 'OO', 'II' )" ).append("\n"); 
		query.append("AND A.WHF_CFM_FLG  = 'Y'" ).append("\n"); 

	}
}