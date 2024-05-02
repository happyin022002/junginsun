/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlForEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlForEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlForEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlForEmlRSQL").append("\n"); 
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
		query.append("#if (${ibflag} == 'ENS') " ).append("\n"); 
		query.append("SELECT A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,A.EDI_RCV_DT" ).append("\n"); 
		query.append("      ,A.EDI_RCV_SEQ" ).append("\n"); 
		query.append("      ,B.RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("      ,C.POL_CD" ).append("\n"); 
		query.append("      ,C.POD_CD" ).append("\n"); 
		query.append("      ,(SELECT OFC_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("              ,BKG_BL_ISS       S" ).append("\n"); 
		query.append("              ,BKG_BOOKING      BKG" ).append("\n"); 
		query.append("         WHERE S.OBL_ISS_OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("           AND S.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BL_NO        = C.BL_NO" ).append("\n"); 
		query.append("       ) AS OFC_ENG_NM" ).append("\n"); 
		query.append("  FROM (SELECT A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("              ,A.BL_NO" ).append("\n"); 
		query.append("              ,B.EDI_RCV_DT" ).append("\n"); 
		query.append("              ,B.EDI_RCV_SEQ" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_EUR_RCV B" ).append("\n"); 
		query.append("         WHERE A.MSG_SND_NO = B.MSG_RCV_NO" ).append("\n"); 
		query.append("           AND B.EDI_RCV_DT = @[edi_rcv_dt]" ).append("\n"); 
		query.append("           AND B.EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_EUR_VSL B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_EUR_BL  C" ).append("\n"); 
		query.append(" WHERE A.VSL_CD        = B.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.CSTMS_PORT_CD = B.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD        = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.CSTMS_PORT_CD = C.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND A.BL_NO         = C.BL_NO(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,B.EDI_RCV_DT" ).append("\n"); 
		query.append("      ,B.EDI_RCV_SEQ" ).append("\n"); 
		query.append("      ,'' RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("      ,C.POL_CD" ).append("\n"); 
		query.append("      ,C.POD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_IO_SND A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_IO_RCV B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_IO_BL  C" ).append("\n"); 
		query.append(" WHERE B.BND_TP_CD   = 'O'" ).append("\n"); 
		query.append("   AND B.EDI_RCV_DT  = @[edi_rcv_dt]" ).append("\n"); 
		query.append("   AND B.EDI_RCV_SEQ = @[edi_rcv_seq]" ).append("\n"); 
		query.append("   AND B.MSG_RCV_NO  = A.MSG_SND_NO(+)" ).append("\n"); 
		query.append("   AND A.BL_NO       = C.BL_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}