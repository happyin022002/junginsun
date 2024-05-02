/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MRN Create를 위한 조회를 한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL(){
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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL").append("\n"); 
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
		query.append("#if(${mrn_yn} != 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(mani.MRN_NO,' ')         MRN_NO" ).append("\n"); 
		query.append("     , NVL(mani.MRN_CHK_NO, ' ')    MRN_CHK_NO" ).append("\n"); 
		query.append("     , NVL(mani.PORT_CD,' ')        PORT_CD" ).append("\n"); 
		query.append("     , NVL(mani.IO_BND_CD,' ')      IO_BND_CD" ).append("\n"); 
		query.append("     , NVL(mani.VSL_CD,' ')         VSL_CD" ).append("\n"); 
		query.append("     , NVL(mani.skd_voy_no,' ')     SKD_VOY_NO" ).append("\n"); 
		query.append("     , NVL(mani.skd_dir_cd,' ')     SKD_DIR_CD" ).append("\n"); 
		query.append("	 , NVL(vsl.SLAN_CD, ' ') LANE" ).append("\n"); 
		query.append("     , NVL(mani.VSL_CD,' ') || NVL(mani.skd_voy_no,' ') || NVL(mani.skd_dir_cd,' ') VVD" ).append("\n"); 
		query.append("     , NVL(v.CALL_SGN_NO,' ')       CALL_SGN_NO" ).append("\n"); 
		query.append("     , NVL(TO_CHAR(vsl.vps_eta_dt,'YYYY-MM-DD'),' ') VPS_ETA_DT" ).append("\n"); 
		query.append("     , NVL(TO_CHAR(vsl.vps_etd_dt,'YYYY-MM-DD'),' ') VPS_ETD_DT" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_MF_REF_NO mani" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD vsl " ).append("\n"); 
		query.append("     , MDM_VSL_CNTR v" ).append("\n"); 
		query.append(" WHERE mani.VSL_CD = v.VSL_CD  " ).append("\n"); 
		query.append("   AND mani.VSL_CD = vsl.VSL_CD  " ).append("\n"); 
		query.append("   AND mani.skd_voy_no = vsl.skd_voy_no  " ).append("\n"); 
		query.append("   AND mani.skd_dir_cd = vsl.skd_dir_cd  " ).append("\n"); 
		query.append("   AND vsl.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("   AND mani.PORT_CD = vsl.VPS_PORT_CD    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${port_cd} != '')" ).append("\n"); 
		query.append("   AND mani.PORT_CD like @[port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("   AND vsl.SLAN_CD like @[lane]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND mani.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd1} != '')" ).append("\n"); 
		query.append("   AND mani.VSL_CD 	   LIKE SUBSTR(@[vvd1],1,4)||'%'" ).append("\n"); 
		query.append("   AND mani.SKD_VOY_NO LIKE SUBSTR(@[vvd1],5,4)||'%'" ).append("\n"); 
		query.append("   AND mani.SKD_DIR_CD LIKE SUBSTR(@[vvd1],9,1)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${crr_cd} != 'H')" ).append("\n"); 
		query.append("   AND v.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND v.CRR_CD = 'SML'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${from_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT > TO_DATE(@[from_dt],'YYYY-MM-DD')   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_dt} != '')" ).append("\n"); 
		query.append("  AND VSL.VPS_ETA_DT < TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("         '' MRN_NO" ).append("\n"); 
		query.append("       , '' MRN_CHK_NO" ).append("\n"); 
		query.append("       , @[port_cd] PORT_CD" ).append("\n"); 
		query.append("       , @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append("       , vsl.VSL_CD VSL_CD" ).append("\n"); 
		query.append("       , vsl.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("       , vsl.SKD_DIR_cD SKD_DIR_CD" ).append("\n"); 
		query.append("       , NVL(vsl.SLAN_CD, ' ') LANE" ).append("\n"); 
		query.append("       , NVL(vsl.VSL_CD,' ') || NVL(vsl.skd_voy_no,' ') || NVL(vsl.skd_dir_cd,' ') VVD" ).append("\n"); 
		query.append("       , NVL(v.CALL_SGN_NO,' ')       CALL_SGN_NO" ).append("\n"); 
		query.append("       , NVL(TO_CHAR(vsl.vps_eta_dt,'YYYY-MM-DD'),' ') VPS_ETA_DT" ).append("\n"); 
		query.append("       , NVL(TO_CHAR(vsl.vps_etd_dt,'YYYY-MM-DD'),' ') VPS_ETD_DT" ).append("\n"); 
		query.append("   FROM VSK_VSL_PORT_SKD vsl " ).append("\n"); 
		query.append("     , MDM_VSL_CNTR v " ).append("\n"); 
		query.append("   WHERE vsl.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("   AND v.VSL_CD =vsl.VSL_CD" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X' FROM BKG_CSTMS_KR_MF_REF_NO BCK" ).append("\n"); 
		query.append("                   WHERE BCK.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                   AND   BCK.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND   BCK.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND   BCK.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                   AND   BCK.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${port_cd} != '')" ).append("\n"); 
		query.append("   AND vsl.VPS_PORT_CD like @[port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("   AND vsl.SLAN_CD like @[lane]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${crr_cd} != 'H')" ).append("\n"); 
		query.append("   AND v.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND v.CRR_CD = 'SML'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd1} != '')" ).append("\n"); 
		query.append("   AND vsl.VSL_CD 	   LIKE SUBSTR(@[vvd1],1,4)||'%'" ).append("\n"); 
		query.append("   AND vsl.SKD_VOY_NO LIKE SUBSTR(@[vvd1],5,4)||'%'" ).append("\n"); 
		query.append("   AND vsl.SKD_DIR_CD LIKE SUBSTR(@[vvd1],9,1)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${from_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT > TO_DATE(@[from_dt],'YYYY-MM-DD')   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_dt} != '')" ).append("\n"); 
		query.append("  AND VSL.VPS_ETA_DT < TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}