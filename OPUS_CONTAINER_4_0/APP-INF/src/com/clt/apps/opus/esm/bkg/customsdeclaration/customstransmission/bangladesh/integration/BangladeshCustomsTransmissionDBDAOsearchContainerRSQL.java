/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.06
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.06 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsTransmissionDBDAOsearchContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관 신고용 Container 정보를 조회한다
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n"); 
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchContainerRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRNBR:'||NVL(CNTR.CNTR_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRTYPE:'||NVL(CNTR.CNTR_TPSZ_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("        'CNTRWGT:'||DECODE(NVL(CNTR.WGT_UT_CD,' '),'LBS', ROUND(NVL(CNTR.CNTR_WGT,0)*0.4536,3),NVL(CNTR.CNTR_WGT,0))||CHR(10)||" ).append("\n"); 
		query.append("        'CNTR_PKG:'||NVL(CNTR.PCK_QTY, 0)||CHR(10)||" ).append("\n"); 
		query.append("        'SEALNBR:'||" ).append("\n"); 
		query.append("		(  SELECT NVL(MIN(BCSN.CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("		   FROM BKG_CNTR_SEAL_NO BCSN" ).append("\n"); 
		query.append("		   WHERE BCSN.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("		   AND BCSN.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		   AND ROWNUM = 1" ).append("\n"); 
		query.append("		   )||CHR(10)||" ).append("\n"); 
		query.append("		'DG_IMCO:'||NVL(BD.IMO_DESC, DECODE(BKG.DCGO_FLG, 'Y',  (SELECT BDCI.IMDG_CLSS_CD FROM BKG_DG_CGO BDCI" ).append("\n"); 
		query.append("		                                        WHERE  BDCI.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("		                                        AND    BDCI.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		                                        AND    BDCI.DG_CNTR_SEQ = 1" ).append("\n"); 
		query.append("												AND    ROWNUM = 1), ' '))||CHR(10)||" ).append("\n"); 
		query.append("		'DG_UN_CD:'||NVL(BD.IMDG_UN_DESC,DECODE(BKG.DCGO_FLG, 'Y', (SELECT BDCU.IMDG_UN_NO FROM BKG_DG_CGO BDCU" ).append("\n"); 
		query.append("		                                        WHERE  BDCU.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("		                                        AND    BDCU.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		                                        AND    BDCU.DG_CNTR_SEQ = 1" ).append("\n"); 
		query.append("												AND    ROWNUM = 1), ' '))||CHR(10)||" ).append("\n"); 
		query.append("	    'CNTR_LOC_CD:'||DECODE(BD.BD_CNTR_LOC_CD,NULL,NVL(DECODE(BKG.DEL_CD, 'BDDAC', '102DICD', ' '), ' '),BD.BD_CNTR_LOC_CD)||CHR(10)||" ).append("\n"); 
		query.append("		'COMMODITY_CD:'||NVL(BD.CMDT_DESC,NVL(SUBSTR(BKG.CMDT_CD, 1, 2), ''))||CHR(10)||--" ).append("\n"); 
		query.append("        'CNTR_FM_IND:'||NVL(BD.BD_CNTR_CGO_TP_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("        '}CNTR_INFO'||CHR(10) cntr_desc" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER CNTR, BKG_BOOKING BKG, BKG_CSTMS_BD_CNTR BD" ).append("\n"); 
		query.append("WHERE  CNTR.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND    CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("--AND    BKG.BL_NO   = BD.BL_NO(+)" ).append("\n"); 
		query.append("AND    CNTR.CNTR_NO = BD.CNTR_NO(+)" ).append("\n"); 

	}
}