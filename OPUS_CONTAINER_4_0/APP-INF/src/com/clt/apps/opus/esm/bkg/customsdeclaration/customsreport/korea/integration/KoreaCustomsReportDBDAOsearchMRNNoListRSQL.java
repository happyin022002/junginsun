/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchMRNNoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.21 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchMRNNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MRN 목록 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchMRNNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOsearchMRNNoListRSQL").append("\n");
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
		query.append("SELECT NVL(MANI.MRN_NO, ' ') MRN_NO" ).append("\n");
		query.append(", NVL(MANI.MRN_CHK_NO, ' ') MRN_CHK_NO" ).append("\n");
		query.append(", NVL(MANI.VSL_CD, ' ') ||  NVL(MANI.SKD_VOY_NO, ' ') || NVL(MANI.SKD_DIR_CD, ' ') VVD_CD" ).append("\n");
		query.append(", NVL(MANI.VSL_CD, ' ') VSL_CD" ).append("\n");
		query.append(", NVL(MANI.SKD_VOY_NO, ' ') SKD_VOY_NO" ).append("\n");
		query.append(", NVL(MANI.SKD_DIR_CD, ' ') SKD_DIR_CD" ).append("\n");
		query.append(", NVL(MANI.PORT_CD, ' ') PORT_CD" ).append("\n");
		query.append(", NVL(MANI.IO_BND_CD, ' ') IO_BND_CD" ).append("\n");
		query.append(", NVL(TO_CHAR(VSL.VPS_ETA_DT, 'YYYY-MM-DD'), ' ') VPS_ETA_DT" ).append("\n");
		query.append(", NVL(TO_CHAR(VSL.VPS_ETD_DT, 'YYYY-MM-DD'), ' ') VPS_ETD_DT" ).append("\n");
		query.append(", NVL(V.CALL_SGN_NO, ' ') CALL_SGN_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO MANI,  VSK_VSL_PORT_SKD VSL ,  MDM_VSL_CNTR V" ).append("\n");
		query.append("WHERE MANI.VSL_CD = V.VSL_CD" ).append("\n");
		query.append("AND MANI.VSL_CD = VSL.VSL_CD" ).append("\n");
		query.append("AND MANI.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n");
		query.append("AND MANI.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n");
		query.append("AND VSL.CLPT_IND_SEQ  = '1'" ).append("\n");
		query.append("AND MANI.PORT_CD = VSL.VPS_PORT_CD" ).append("\n");
		query.append("#if(${vsl_cd}!='')" ).append("\n");
		query.append("AND MANI.VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${skd_voy_no}!='')" ).append("\n");
		query.append("AND MANI.SKD_VOY_NO = @[skd_voy_no]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${skd_dir_cd}!='')" ).append("\n");
		query.append("AND MANI.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${mrn_no} != '')" ).append("\n");
		query.append("AND MANI.MRN_NO LIKE @[mrn_no] || '%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${port_cd} != '')" ).append("\n");
		query.append("AND MANI.PORT_CD LIKE @[port_cd] || '%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${io_bnd_cd} != '')" ).append("\n");
		query.append("AND MANI.IO_BND_CD LIKE @[io_bnd_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${io_bnd_cd} != 'O')" ).append("\n");
		query.append("#if(${from_dt} !='')" ).append("\n");
		query.append("AND VSL.VPS_ETA_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${to_dt} !='')" ).append("\n");
		query.append("AND VSL.VPS_ETA_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("#if(${from_dt} !='')" ).append("\n");
		query.append("AND VSL.VPS_ETD_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${to_dt} !='')" ).append("\n");
		query.append("AND VSL.VPS_ETD_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");

	}
}