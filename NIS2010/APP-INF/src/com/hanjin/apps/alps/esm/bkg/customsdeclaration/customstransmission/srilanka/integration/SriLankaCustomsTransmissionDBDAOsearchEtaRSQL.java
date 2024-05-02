/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카 세관 신고용 Manifest Estimated Date 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_pol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchEtaRSQL").append("\n"); 
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
		query.append("#if(${ver_flg}=='O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	NVL(TO_CHAR(VPS_ETA_DT,'YYYYMMDD'),' ') VPS_ETA_DT" ).append("\n"); 
		query.append("FROM   	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  	VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    	VPS_PORT_CD    = @[vvd_pod]" ).append("\n"); 
		query.append("AND    	NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND    	CLPT_IND_SEQ  = (	SELECT	MAX(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                        	FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        	WHERE   VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("							AND     SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("							AND     SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("							AND     VPS_PORT_CD    = @[vvd_pod]" ).append("\n"); 
		query.append("                        	AND     NVL(SKD_CNG_STS_CD,' ') <> 'S'	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		#if(${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("		NVL(TO_CHAR(  GLOBALDATE_PKG.TIME_CONV_FNC ( @[pod_cd], VPS_ETA_DT ,'GMT') ,'YYYYMMDDHH24MISS')||'UTC',' ') VPS_ETA_DT" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		NVL(TO_CHAR(  GLOBALDATE_PKG.TIME_CONV_FNC ( @[pol_cd], VPS_ETD_DT ,'GMT') ,'YYYYMMDDHH24MISS')||'UTC',' ') VPS_ETA_DT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM   	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  	VSL_CD    	= @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 
		query.append("#if(${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("AND    VPS_PORT_CD 	= @[vvd_pod]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    VPS_PORT_CD 	= @[vvd_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND    CLPT_IND_SEQ  = (	SELECT  MAX(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                        	FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        	WHERE   VSL_CD         	= @[vsl_cd]" ).append("\n"); 
		query.append("							AND     SKD_VOY_NO     	= @[skd_voy_no]" ).append("\n"); 
		query.append("							AND     SKD_DIR_CD     	= @[skd_dir_cd]" ).append("\n"); 
		query.append("							#if(${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("							AND    	VPS_PORT_CD 	= @[vvd_pod]" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							AND    	VPS_PORT_CD 	= @[vvd_pol]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                        	AND     NVL(SKD_CNG_STS_CD,' ') <> 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}