/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyDiscSendDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOmodifyDiscSendDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manifest 전송시각 UPDATE
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyDiscSendDateUSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOmodifyDiscSendDateUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("SET DCHG_RPT_DT     = sysdate," ).append("\n"); 
		query.append("DCHG_SND_USR_ID = @[user_id]" ).append("\n"); 
		query.append("WHERE (BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, TRNS_SEQ)" ).append("\n"); 
		query.append("IN ( SELECT BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#if(${in_type} == 'D')" ).append("\n"); 
		query.append("AND DECODE(KR_CSTMS_BND_CD,NULL,'N',' ','N',KR_CSTMS_BND_CD) IN ('A','B','C','M'))" ).append("\n"); 
		query.append("#elseif(${in_type} != 'N')" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD = @[in_type]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND KR_CSTMS_BND_CD IN ('A','R','T','M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],   'I',    CSTMS_DECL_TP_CD,     'I') IN ('I', 'T')" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],   'O',    CSTMS_DECL_TP_CD,     'E') IN ('E', 'R')" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],   'I',    TS_POD_CD,    TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("AND DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' ')" ).append("\n"); 
		query.append("GROUP BY BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n"); 
		query.append("HAVING SUBSTR(MIN(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}