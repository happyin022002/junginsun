/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsortiumVoyageMgtDBDAOFirstVirtualPortConsortiumVoyageVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsortiumVoyageMgtDBDAOFirstVirtualPortConsortiumVoyageVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * First Virtual Port Consortium Voyage Update
	  * </pre>
	  */
	public ConsortiumVoyageMgtDBDAOFirstVirtualPortConsortiumVoyageVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration").append("\n"); 
		query.append("FileName : ConsortiumVoyageMgtDBDAOFirstVirtualPortConsortiumVoyageVOUSQL").append("\n"); 
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
		query.append("UPDATE       VSK_VSL_PORT_SKD      			PS" ).append("\n"); 
		query.append("SET          PS.IB_CSSM_VOY_NO     			= @[ib_cssm_voy_no]" ).append("\n"); 
		query.append("		,	 PS.UPD_USR_ID     				= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	 PS.UPD_DT         				= SYSDATE" ).append("\n"); 
		query.append("		,	 PS.CSSM_VOY_INIT_CRE_FLG  		= 'N'" ).append("\n"); 
		query.append("WHERE        (PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD,PS.VPS_PORT_CD,PS.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("             IN" ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("             --==========================================================" ).append("\n"); 
		query.append("              SELECT       X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD,X.VPS_PORT_CD,X.CLPT_IND_SEQ        " ).append("\n"); 
		query.append("              FROM         (" ).append("\n"); 
		query.append("                           ------------------------------------------------------------" ).append("\n"); 
		query.append("                            SELECT       ROW_NUMBER() OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.TURN_PORT_IND_CD,'Y',1,'N',2,9) DESC, PS.CLPT_SEQ ASC) VIR_PORT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                      ,  PS.VSL_CD" ).append("\n"); 
		query.append("                                      ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            FROM         VSK_VSL_PORT_SKD     PS" ).append("\n"); 
		query.append("                            WHERE        PS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND          PS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("                            AND          PS.SKD_DIR_CD        = @[skd_dir_cd]  " ).append("\n"); 
		query.append("                            AND          PS.TURN_PORT_IND_CD  IN ('D','V','F')        " ).append("\n"); 
		query.append("                           ------------------------------------------------------------ " ).append("\n"); 
		query.append("                           ) X" ).append("\n"); 
		query.append("              WHERE        X.VIR_PORT_SEQ                     = 1                         " ).append("\n"); 
		query.append("             --==========================================================             " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             OR" ).append("\n"); 
		query.append("             (PS.VSL_CD,PS.TURN_SKD_VOY_NO,PS.TURN_SKD_DIR_CD,PS.VPS_PORT_CD,PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             IN" ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("             --==========================================================" ).append("\n"); 
		query.append("              SELECT       X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD,X.VPS_PORT_CD,X.CLPT_IND_SEQ        " ).append("\n"); 
		query.append("              FROM         (" ).append("\n"); 
		query.append("                           ------------------------------------------------------------" ).append("\n"); 
		query.append("                            SELECT       ROW_NUMBER() OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.TURN_PORT_IND_CD,'Y',1,'N',2,9) DESC, PS.CLPT_SEQ ASC) VIR_PORT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                      ,  PS.VSL_CD" ).append("\n"); 
		query.append("                                      ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            FROM         VSK_VSL_PORT_SKD     PS" ).append("\n"); 
		query.append("                            WHERE        PS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND          PS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("                            AND          PS.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            AND          PS.TURN_PORT_IND_CD  IN ('D','V','F')        " ).append("\n"); 
		query.append("                           ------------------------------------------------------------ " ).append("\n"); 
		query.append("                           ) X  " ).append("\n"); 
		query.append("              WHERE        X.VIR_PORT_SEQ                     = 1                            " ).append("\n"); 
		query.append("             --==========================================================             " ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}