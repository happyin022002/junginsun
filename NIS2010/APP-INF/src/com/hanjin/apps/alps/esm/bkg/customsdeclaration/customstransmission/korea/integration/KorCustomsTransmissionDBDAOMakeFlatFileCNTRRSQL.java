/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileCNTRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileCNTRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeFlatFileCNTR
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileCNTRRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT SUBSTR(MAX(TO_CHAR(KC.TRNS_SEQ, '00000')||" ).append("\n"); 
		query.append("'{CNTR_INFO'    ||CHR(10)||                         /*  Start of E/L Block  */" ).append("\n"); 
		query.append("'CNTRNBR:'      ||FC2S(KC.CNTR_NO,'S')  ||CHR(10)|| /*  Export License No   */" ).append("\n"); 
		query.append("'LDMT:'         ||KC.FULL_MTY_CD     ||CHR(10)||    /*  Package Unit        */" ).append("\n"); 
		query.append("'SEALNBR:'      ||FC2S(KC.CNTR_SEAL_NO,'S')  ||CHR(10)|| /*  Package Count       */" ).append("\n"); 
		query.append("'CNTRTYPE:'     ||KC.CNTR_TPSZ_CD  ||CHR(10)||      /*  Weight Unit         */" ).append("\n"); 
		query.append("'PKG:'          ||PCK_QTY       ||CHR(10)||         /*  Weight              */" ).append("\n"); 
		query.append("'PKGU:'         ||KC.PCK_TP_CD  ||CHR(10)||         /*  분할선적 여부       */" ).append("\n"); 
		query.append("'WGT:'          ||KC.CNTR_WGT   ||CHR(10)||         /*  This E/L No         */" ).append("\n"); 
		query.append("'WGTU:'         ||KC.WGT_UT_CD  ||CHR(10)||         /*  동시 포장 여부      */" ).append("\n"); 
		query.append("'MEA:'          ||KC.MEAS_QTY   ||CHR(10)||         /*  Unit Pakage Unit    */" ).append("\n"); 
		query.append("'MEAU:'         ||KC.MEAS_UT_CD ||CHR(10)||         /*  Unit Package Count  */" ).append("\n"); 
		query.append("'}CNTR_INFO'    ||CHR(10)" ).append("\n"); 
		query.append("), 7) CNTR_DATA" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_CNTR KC" ).append("\n"); 
		query.append("WHERE KC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND KC.CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n"); 
		query.append("AND KC.DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("GROUP BY KC.CNTR_NO" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileCNTRRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}