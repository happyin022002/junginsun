/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ajsk
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL").append("\n"); 
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
		query.append("SELECT TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append(", TML_PROD_RPT_RSN_DESC" ).append("\n"); 
		query.append(", CASE WHEN TML_PROD_RPT_RSN_CD = 	(	SELECT TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("FROM	OPF_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("WHERE	VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	=	@[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	=	@[skd_dir_cd]" ).append("\n"); 
		query.append("AND		CLPT_CD		=	@[port_cd]" ).append("\n"); 
		query.append("AND		CLPT_IND_SEQ =	@[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN	'1'	ELSE	'0'	END	AS	TDR_RPT_RSN_CD" ).append("\n"); 
		query.append(", CASE WHEN TML_PROD_RPT_RSN_CD =	(	SELECT 	TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("FROM	OPF_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("WHERE	VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	=	@[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	=	@[skd_dir_cd]" ).append("\n"); 
		query.append("AND		CLPT_CD		=	@[port_cd]" ).append("\n"); 
		query.append("AND		CLPT_IND_SEQ =	@[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN	(	SELECT 	VSL_CD			||	'_/'	||" ).append("\n"); 
		query.append("SKD_VOY_NO	    ||	'_/'	||" ).append("\n"); 
		query.append("SKD_DIR_CD	    ||	'_/'	||" ).append("\n"); 
		query.append("CLPT_IND_SEQ    ||	'_/'	||" ).append("\n"); 
		query.append("CLPT_CD		    ||	'_/'	||" ).append("\n"); 
		query.append("TML_PROD_RPT_RSN_RMK" ).append("\n"); 
		query.append("FROM	OPF_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("WHERE	VSL_CD		=	@[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	=	@[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	=	@[skd_dir_cd]" ).append("\n"); 
		query.append("AND		CLPT_CD		=	@[port_cd]" ).append("\n"); 
		query.append("AND		CLPT_IND_SEQ =	@[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE	NULL	END	AS	KEY_OF_REMARK" ).append("\n"); 
		query.append("FROM	OPF_TML_PROD_RPT_RSN_CD	A" ).append("\n"); 
		query.append("WHERE	DELT_FLG		=	'N'" ).append("\n"); 

	}
}