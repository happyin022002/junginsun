/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchInboundVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
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

public class GeneralInvoiceAuditDBDAOSearchInboundVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outbound vvd 일때 IO=IN 이면 Inbound vvd를 조회함.
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchInboundVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchInboundVvdRSQL").append("\n"); 
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
		query.append("SELECT A.TURN_PORT_FLG" ).append("\n"); 
		query.append("     , VPS.VSL_CD||'|'||VPS.SKD_VOY_NO||'|'||VPS.SKD_DIR_CD||'|'||VPS.CLPT_IND_SEQ AS VVD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("     , (SELECT TURN_PORT_FLG" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , DECODE(TURN_PORT_FLG,'Y', TURN_SKD_VOY_NO    , SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , DECODE(TURN_PORT_FLG,'Y', TURN_SKD_DIR_CD    , SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , DECODE(TURN_PORT_FLG,'Y', TURN_CLPT_IND_SEQ  , CLPT_IND_SEQ) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("           AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("          ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND NVL(VPS.SKD_CNG_STS_CD   , 'X') <> 'S'" ).append("\n"); 
		query.append("   AND NVL(VPS.VT_ADD_CALL_FLG  , 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND VPS.VSL_CD               = A.VSL_CD" ).append("\n"); 
		query.append("   AND VPS.SKD_VOY_NO           = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VPS.SKD_DIR_CD           = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VPS.CLPT_IND_SEQ         = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND VPS.TURN_SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VPS.TURN_SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VPS.TURN_CLPT_IND_SEQ    = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND VPS.YD_CD                = A.YD_CD" ).append("\n"); 

	}
}