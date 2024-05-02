/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
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
	  * Tariff 비용 계산을 위해 최근 처리된 Invoice 의 ETD 을 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
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
		query.append("select 'TO_DATE('''||NVL(TO_CHAR(MAX(B.vps_Etd_dt),'YYYYMMDD'),'19000101')||''',''YYYYMMDD'')'" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("from vsk_bud_vsl_port_skd A, vsk_vsl_port_skd B,  pso_charge C1, pso_chg_dtl C2  " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("from vsk_vsl_port_skd A, vsk_vsl_port_skd B,  pso_charge C1, pso_chg_dtl C2  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where   A.vps_etd_dt > B.vps_Etd_dt" ).append("\n"); 
		query.append("and A.vsl_cd        = B.vsl_cd" ).append("\n"); 
		query.append("AND A.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("and A.yd_cd   = @[yd_cd]--'CNTAOY1'" ).append("\n"); 
		query.append("and C1.ISS_CTY_CD   = C2.ISS_CTY_CD" ).append("\n"); 
		query.append("and C1.SO_SEQ       = C2.SO_SEQ" ).append("\n"); 
		query.append("and C2.vsl_cd       = B.vsl_cd" ).append("\n"); 
		query.append("and C2.skd_voy_no   = B.skd_voy_no" ).append("\n"); 
		query.append("and C2.skd_dir_cd   = B.skd_dir_cd" ).append("\n"); 
		query.append("and C1.yd_cd        = B.yd_cd" ).append("\n"); 
		query.append("and C2.lgs_cost_cd  = @[lgs_cost_cd]--'PTDUTN'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${port_cd} == 'JPTYO' || ${port_cd} == 'JPYOK' || ${port_cd} == 'JPKNZ' )" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD IN ('JPTYO', 'JPYOK', 'JPKNZ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif( ${cnt_cd} == 'JP' )" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD   = B.VPS_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.YD_CD         LIKE SUBSTR(A.VPS_PORT_CD,1,2)||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}