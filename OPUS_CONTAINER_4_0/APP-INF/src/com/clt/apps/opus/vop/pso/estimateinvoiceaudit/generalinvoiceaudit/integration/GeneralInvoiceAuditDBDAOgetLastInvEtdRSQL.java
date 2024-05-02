/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getLastInvEtd
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL(){
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL").append("\n"); 
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
		query.append("SELECT 'TO_DATE('''||NVL(TO_CHAR(MAX(B.VPS_ETD_DT),'YYYYMMDD'),'19000101')||''',''YYYYMMDD'')'" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("     , PSO_CHARGE C1" ).append("\n"); 
		query.append("     , PSO_CHG_DTL C2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD         = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO     = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD     = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND A.YD_CD          = @[yd_cd] --'CNTAOY1'" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND A.VPS_ETD_DT     > B.VPS_ETD_DT" ).append("\n"); 
		query.append("   AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("   AND NVL(B.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND NVL(B.SKD_CNG_STS_CD, ' ') != 'S' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND C1.ISS_CTY_CD    = C2.ISS_CTY_CD" ).append("\n"); 
		query.append("   AND C1.SO_SEQ        = C2.SO_SEQ" ).append("\n"); 
		query.append("   AND C2.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("   AND C2.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C2.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND C1.YD_CD         = B.YD_CD" ).append("\n"); 
		query.append("   AND C2.LGS_COST_CD   = @[lgs_cost_cd] --'PTDUTN'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${port_cd} == 'JPTYO' || ${port_cd} == 'JPYOK' || ${port_cd} == 'JPKNZ' )" ).append("\n"); 
		query.append("   AND B.VPS_PORT_CD IN ('JPTYO', 'JPYOK', 'JPKNZ')" ).append("\n"); 
		query.append("#elseif( ${cnt_cd} == 'JP' )" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD    = B.VPS_PORT_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND B.YD_CD LIKE SUBSTR(A.VPS_PORT_CD,1,2)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}