/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDaoDAOgetLoadedTeuLastPortRSQL.java
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

public class GeneralInvoiceAuditDBDaoDAOgetLoadedTeuLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD, Port의 이전 Port에서 선적된 CNTR TEU를 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDaoDAOgetLoadedTeuLastPortRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDaoDAOgetLoadedTeuLastPortRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(H.CNTR_SIZE, '2', 1, 2) * H.QTY) TEU" ).append("\n"); 
		query.append("FROM (SELECT PRE.VSL_CD, PRE.SKD_VOY_NO, PRE.SKD_DIR_CD, PRE.VPS_PORT_CD, PRE.CLPT_IND_SEQ, TG.VPS_PORT_CD NEXT_PORT" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD PRE, VSK_VSL_PORT_SKD TG" ).append("\n"); 
		query.append("       WHERE TG.VSL_CD       = SUBSTR(@[vvd], 1, 4)     --:vsl_cd" ).append("\n"); 
		query.append("		 AND TG.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)     --:skd_voy_no" ).append("\n"); 
		query.append("		 AND TG.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)        --:skd_dir_cd" ).append("\n"); 
		query.append("		 AND TG.YD_CD        = @[yd_cd]  --:port_cd" ).append("\n"); 
		query.append("		 AND PRE.VSL_CD = TG.VSL_CD" ).append("\n"); 
		query.append("         AND PRE.SKD_VOY_NO = TG.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND PRE.SKD_DIR_CD = TG.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND PRE.CLPT_SEQ = TG.CLPT_SEQ - 1" ).append("\n"); 
		query.append("     ) V, (SELECT VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, CNTR_SIZE, COUNT(*) QTY" ).append("\n"); 
		query.append("            FROM BAY_PLAN" ).append("\n"); 
		query.append("           WHERE FE = 'F'	-- Full CNTR만 대상으로 한다." ).append("\n"); 
		query.append("			 AND VSL_CD   = SUBSTR(@[vvd], 1, 4)     --:vsl_cd" ).append("\n"); 
		query.append("		 	 AND VOY_NO   = SUBSTR(@[vvd], 5, 4)     --:skd_voy_no" ).append("\n"); 
		query.append("		 	 AND DIR_CD   = SUBSTR(@[vvd], 9, 1)        --:skd_dir_cd" ).append("\n"); 
		query.append("           GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, CNTR_SIZE) H" ).append("\n"); 
		query.append("WHERE  V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 

	}
}