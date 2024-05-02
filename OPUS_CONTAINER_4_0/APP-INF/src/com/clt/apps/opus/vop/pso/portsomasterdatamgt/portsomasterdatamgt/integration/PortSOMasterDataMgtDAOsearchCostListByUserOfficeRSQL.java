/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cost 조회
	  * [2015.10.13]962111 OWNERS ACCOUNT INTER-OFFICE ACCT 주석처리.
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("charge_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL").append("\n"); 
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
		query.append("SELECT @[charge_type]" ).append("\n"); 
		query.append("     , T2.ACCT_CD" ).append("\n"); 
		query.append("     , T2.LGS_COST_CD" ).append("\n"); 
		query.append("     , LGS_COST_FULL_NM" ).append("\n"); 
		query.append("     , DECODE(T1.LGS_COST_CD, NULL, '0', '1') AS CHK" ).append("\n"); 
		query.append("     , T1.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(T1.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("  FROM PSO_INV_OFC_COST T1" ).append("\n"); 
		query.append("     , TES_LGS_COST T2" ).append("\n"); 
		query.append(" WHERE T1.LGS_COST_CD (+) = T2.LGS_COST_CD" ).append("\n"); 
		query.append("   AND T1.OFC_CD (+) = @[ofc_cd]" ).append("\n"); 
		query.append("   AND T2.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("#if( ${charge_type} == '0')" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD = 'PT'" ).append("\n"); 
		query.append("   AND T2.LGS_COST_DTL_CD = 'PTDU'" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '1')" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD = 'PT'" ).append("\n"); 
		query.append("   AND T2.LGS_COST_DTL_CD = 'PTSV'" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '2')" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD = 'CN'" ).append("\n"); 
		query.append("#elseif( ${charge_type} == '3')" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD = 'PT'" ).append("\n"); 
		query.append("   AND T2.LGS_COST_DTL_CD = 'PTXX'" ).append("\n"); 
		query.append("   AND T2.ACCT_CD NOT IN ( '110911')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY T2.LGS_COST_OPT_NO" ).append("\n"); 

	}
}