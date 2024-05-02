/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOUpdateVskVslVirtualPortSkdtoOriginalEstmDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOUpdateVskVslVirtualPortSkdtoOriginalEstmDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual SKED Delete시에 Virtual Port에 대한 Date 원복처리
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOUpdateVskVslVirtualPortSkdtoOriginalEstmDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOUpdateVskVslVirtualPortSkdtoOriginalEstmDateUSQL").append("\n"); 
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
		query.append("UPDATE		VSK_VSL_PORT_SKD	PS" ).append("\n"); 
		query.append("   SET		PS.PORT_SKD_STS_CD	= NULL" ).append("\n"); 
		query.append("		,	PS.VPS_ETA_DT      	=  NVL((" ).append("\n"); 
		query.append("                                	--::2015-04-22::--" ).append("\n"); 
		query.append("								    --SELECT  AK.LST_ETA_DT" ).append("\n"); 
		query.append("                                    --FROM    VSK_ACT_PORT_SKD  AK" ).append("\n"); 
		query.append("                                    --WHERE   AK.VSL_CD         = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_VOY_NO     = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_DIR_CD     = " ).append("\n"); 
		query.append("                                    --AND     AK.VPS_PORT_CD    = " ).append("\n"); 
		query.append("                                    --AND     AK.CLPT_IND_SEQ   = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									SELECT   H.LST_ETA_DT" ).append("\n"); 
		query.append("									FROM     VSK_ACT_PORT_SKD_HIS H" ).append("\n"); 
		query.append("									WHERE    H.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("									AND      H.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("									AND      H.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("									AND      H.VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("									AND      H.CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 
		query.append("									AND      H.CNG_SEQ           = (SELECT  MAX(HH.CNG_SEQ)" ).append("\n"); 
		query.append("								                                	FROM    VSK_ACT_PORT_SKD_HIS  HH" ).append("\n"); 
		query.append("								                                	WHERE   HH.VSL_CD             = H.VSL_CD" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_VOY_NO         = H.SKD_VOY_NO" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_DIR_CD         = H.SKD_DIR_CD" ).append("\n"); 
		query.append("								                                	AND     HH.VPS_PORT_CD        = H.VPS_PORT_CD" ).append("\n"); 
		query.append("								                                	AND     HH.CLPT_IND_SEQ       = H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("								                                	AND     HH.HIS_CRE_RSN_CD     = 'I'" ).append("\n"); 
		query.append("								                                	)" ).append("\n"); 
		query.append("                                    ),PS.VPS_ETA_DT)" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("      ,    PS.VPS_ETB_DT      =  NVL((" ).append("\n"); 
		query.append("                                	--::2015-04-22::--" ).append("\n"); 
		query.append("								    --SELECT  AK.LST_ETB_DT" ).append("\n"); 
		query.append("                                    --FROM    VSK_ACT_PORT_SKD  AK" ).append("\n"); 
		query.append("                                    --WHERE   AK.VSL_CD         = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_VOY_NO     = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_DIR_CD     = " ).append("\n"); 
		query.append("                                    --AND     AK.VPS_PORT_CD    = " ).append("\n"); 
		query.append("                                    --AND     AK.CLPT_IND_SEQ   = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									SELECT   H.LST_ETB_DT" ).append("\n"); 
		query.append("									FROM     VSK_ACT_PORT_SKD_HIS H" ).append("\n"); 
		query.append("									WHERE    H.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("									AND      H.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("									AND      H.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("									AND      H.VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("									AND      H.CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 
		query.append("									AND      H.CNG_SEQ           = (SELECT  MAX(HH.CNG_SEQ)" ).append("\n"); 
		query.append("								                                	FROM    VSK_ACT_PORT_SKD_HIS  HH" ).append("\n"); 
		query.append("								                                	WHERE   HH.VSL_CD             = H.VSL_CD" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_VOY_NO         = H.SKD_VOY_NO" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_DIR_CD         = H.SKD_DIR_CD" ).append("\n"); 
		query.append("								                                	AND     HH.VPS_PORT_CD        = H.VPS_PORT_CD" ).append("\n"); 
		query.append("								                                	AND     HH.CLPT_IND_SEQ       = H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("								                                	AND     HH.HIS_CRE_RSN_CD     = 'I'" ).append("\n"); 
		query.append("								                                	)" ).append("\n"); 
		query.append("                                    ),PS.VPS_ETB_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,     PS.VPS_ETD_DT      =  NVL((" ).append("\n"); 
		query.append("                                	--::2015-04-22::--" ).append("\n"); 
		query.append("								    --SELECT  AK.LST_ETD_DT" ).append("\n"); 
		query.append("                                    --FROM    VSK_ACT_PORT_SKD  AK" ).append("\n"); 
		query.append("                                    --WHERE   AK.VSL_CD         = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_VOY_NO     = " ).append("\n"); 
		query.append("                                    --AND     AK.SKD_DIR_CD     = " ).append("\n"); 
		query.append("                                    --AND     AK.VPS_PORT_CD    = " ).append("\n"); 
		query.append("                                    --AND     AK.CLPT_IND_SEQ   = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									SELECT   H.LST_ETD_DT" ).append("\n"); 
		query.append("									FROM     VSK_ACT_PORT_SKD_HIS H" ).append("\n"); 
		query.append("									WHERE    H.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("									AND      H.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("									AND      H.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("									AND      H.VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("									AND      H.CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 
		query.append("									AND      H.CNG_SEQ           = (SELECT  MAX(HH.CNG_SEQ)" ).append("\n"); 
		query.append("								                                	FROM    VSK_ACT_PORT_SKD_HIS  HH" ).append("\n"); 
		query.append("								                                	WHERE   HH.VSL_CD             = H.VSL_CD" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_VOY_NO         = H.SKD_VOY_NO" ).append("\n"); 
		query.append("								                                	AND     HH.SKD_DIR_CD         = H.SKD_DIR_CD" ).append("\n"); 
		query.append("								                                	AND     HH.VPS_PORT_CD        = H.VPS_PORT_CD" ).append("\n"); 
		query.append("								                                	AND     HH.CLPT_IND_SEQ       = H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("								                                	AND     HH.HIS_CRE_RSN_CD     = 'I'" ).append("\n"); 
		query.append("								                                	)" ).append("\n"); 
		query.append("                                    ),PS.VPS_ETD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       PS.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("AND       PS.TURN_SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("AND       PS.TURN_SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND       PS.VPS_PORT_CD            = @[vps_port_cd]" ).append("\n"); 
		query.append("AND       PS.TURN_CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 

	}
}