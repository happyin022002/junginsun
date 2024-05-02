/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchPortListByBndVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchPortListByBndVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    [] ARInvoiceExRateMgtDBDAO::searchPortListByBnd ( searchByBndVo )
	  * in: SearchVVDPortVO
	  * out: VVDandPortListVO[]
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchPortListByBndVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etda_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etda_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchPortListByBndVORSQL").append("\n"); 
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
		query.append("SELECT 	@[io_bnd_cd] IO_BND_CD," ).append("\n"); 
		query.append("		B.VPS_PORT_CD VPS_PORT_CD, " ).append("\n"); 
		query.append("		NVL((A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD),(B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD)) VVD_CD ," ).append("\n"); 
		query.append("		A.SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("		DECODE(@[io_bnd_cd],'O','ETD','ETA') ETDA_CD," ).append("\n"); 
		query.append("		DECODE(@[io_bnd_cd],'I',TO_CHAR(B.VPS_ETA_DT,'yyyymmdd'),to_char(B.VPS_ETD_DT,'yyyymmdd')) ETDA_DT," ).append("\n"); 
		query.append("		A.INV_XCH_RT INV_XCH_RT,--2010-01-09 ivs_xch_rt 뺌" ).append("\n"); 
		query.append("	    B.CLPT_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD B,INV_VVD_XCH_RT A" ).append("\n"); 
		query.append("WHERE A.VSL_CD(+) = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD(+) = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD,'N') <>'S'" ).append("\n"); 
		query.append("AND A.IO_BND_CD(+) = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND A.LOCL_CURR_CD(+) = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND A.CHG_CURR_CD(+) = 'USD'" ).append("\n"); 
		query.append("#if (${vps_port_cd} != 'ALL') " ).append("\n"); 
		query.append("AND B.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'ALL') " ).append("\n"); 
		query.append("AND A.SVC_SCP_CD=@[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opt_type} == 'V') " ).append("\n"); 
		query.append("    AND B.VSL_CD = substr(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("    AND B.SKD_VOY_NO  = substr(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("    AND B.SKD_DIR_CD = substr(@[vvd_cd],9,1)	" ).append("\n"); 
		query.append("	AND (B.CLPT_IND_SEQ,B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD,B.VPS_PORT_CD) in (" ).append("\n"); 
		query.append("						SELECT MIN(CLPT_IND_SEQ) CLPT_IND_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("						  WHERE VPS_PORT_CD  LIKE (SELECT SUBSTR(LOC_CD,1,2) FROM MDM_ORGANIZATION WHERE OFC_CD =@[ofc_cd])||'%'" ).append("\n"); 
		query.append("						 GROUP BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("	AND B.VPS_ETA_DT BETWEEN TO_DATE(@[etda_dt_fm],'YYYYMMDD') AND TO_DATE(@[etda_dt_to],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND B.VPS_ETD_DT BETWEEN TO_DATE(@[etda_dt_fm],'YYYYMMDD') AND TO_DATE(@[etda_dt_to],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND VPS_PORT_CD  LIKE (SELECT SUBSTR(LOC_CD,1,2) FROM MDM_ORGANIZATION WHERE OFC_CD =@[ofc_cd])||'%'" ).append("\n"); 

	}
}