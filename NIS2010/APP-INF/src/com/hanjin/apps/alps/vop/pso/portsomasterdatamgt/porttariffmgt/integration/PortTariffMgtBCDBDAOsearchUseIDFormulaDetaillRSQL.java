/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.19 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 Terminal에서 해당 Formula를 사용하고 있는 Terminal List를 조회한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD YD_CD" ).append("\n"); 
		query.append(",B.ACCT_CD ACCT_CD" ).append("\n"); 
		query.append(",A.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append(",D.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append(",A.YD_CHG_VER_SEQ VER" ).append("\n"); 
		query.append(",A.PSO_CHG_TP_CD CHG_TP" ).append("\n"); 
		query.append(",C.INTG_CD_VAL_DP_DESC CHG_TP_NM" ).append("\n"); 
		query.append(",@[id_no] ID_NO" ).append("\n"); 
		query.append(",'F' ID_TP" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT DISTINCT T3.YD_CD" ).append("\n"); 
		query.append(",T3.LGS_COST_CD" ).append("\n"); 
		query.append(",T3.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",T2.PSO_CHG_TP_CD" ).append("\n"); 
		query.append(",T3.VNDR_SEQ" ).append("\n"); 
		query.append("FROM   PSO_CHG_XPR_DTL T1" ).append("\n"); 
		query.append(",PSO_YD_CHG_XPR T2" ).append("\n"); 
		query.append(",PSO_YD_CHG T3" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T1.CHG_XPR_NO = T2.CHG_XPR_NO" ).append("\n"); 
		query.append("AND    T2.YD_CHG_NO = T3.YD_CHG_NO" ).append("\n"); 
		query.append("AND    T2.YD_CHG_VER_SEQ = T3.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND    T1.FOML_NO = @[id_no]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",TES_LGS_COST B" ).append("\n"); 
		query.append(",(SELECT B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD     A" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.INTG_CD_ID = 'CD01842'" ).append("\n"); 
		query.append("AND    A.INTG_CD_ID = B.INTG_CD_ID) C" ).append("\n"); 
		query.append(",MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("AND     A.PSO_CHG_TP_CD = C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND     D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     D.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",4" ).append("\n"); 
		query.append(",5" ).append("\n"); 
		query.append(",6" ).append("\n"); 

	}
}