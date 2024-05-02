/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIBLocBlTpCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchIBLocBlTpCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOCAL의 BL Type COUNT 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIBLocBlTpCntRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_port",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT count(decode(KR_CSTMS_BL_TP_CD, 'S', 'x', NULL)) BL_TP_SIMPLE" ).append("\n"); 
		query.append(", count(decode(KR_CSTMS_BL_TP_CD, 'C', 'x', NULL)) BL_TP_CONSOLE" ).append("\n"); 
		query.append(", count(decode(KR_CSTMS_BL_TP_CD, 'E', 'x', NULL)) BL_TP_EMPTY" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO A," ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("BKG_VVD C" ).append("\n"); 
		query.append("WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.MF_REF_NO = @[mrn_nbr]" ).append("\n"); 
		query.append("AND A.MRN_BL_TS_CD = 'I'" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.POD_CD = @[mrn_port]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchIBLocBlTpCntRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}