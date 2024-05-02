/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MakeFlatFileExportNo
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL(){
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
		query.append("SELECT SUBSTR(MAX(TO_CHAR(KE.TRNS_SEQ, '00000')||" ).append("\n");
		query.append("'{KCS_EXNO'                                ||CHR(10)|| /*  Start of E/L Block  */" ).append("\n");
		query.append("'B_EXNO:'           ||KE.XPT_LIC_NO        ||CHR(10)|| /*  Export License No   */" ).append("\n");
		query.append("'B_UCRNO:'          ||BME.UCR_NO           ||CHR(10)|| /*  UCR No              */" ).append("\n");
		query.append("'B_PKGU:'           ||KE.PCK_TP_CD         ||CHR(10)|| /*  Package Unit        */" ).append("\n");
		query.append("'B_PKG:'            ||KE.PCK_QTY           ||CHR(10)|| /*  Package Count       */" ).append("\n");
		query.append("'B_WGTU:'           ||KE.WGT_UT_CD         ||CHR(10)|| /*  Weight Unit         */" ).append("\n");
		query.append("'B_WGT:'            ||KE.CNTR_WGT          ||CHR(10)|| /*  Weight              */" ).append("\n");
		query.append("'PART_EXNO:'        ||KE.PRT_LODG_FLG      ||CHR(10)|| /*  분할선적 여부        */" ).append("\n");
		query.append("'THIS_EXNO:'        ||KE.PRT_LODG_SEQ      ||CHR(10)|| /*  This E/L No         */" ).append("\n");
		query.append("'UNIT_EXNO:'        ||KE.KR_XPT_PCK_ID     ||CHR(10)|| /*  동시 포장 여부       */" ).append("\n");
		query.append("'UNIT_PKGU:'        ||KE.DIVD_PCK_UT_CD    ||CHR(10)|| /*  Unit Pakage Unit    */" ).append("\n");
		query.append("'UNIT_PKG:'         ||KE.DIVD_PCK_QTY      ||CHR(10)|| /*  Unit Package Count  */" ).append("\n");
		query.append("'}KCS_EXNO'         ||CHR(10)" ).append("\n");
		query.append("), 7) EL_DATA" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_XPT_LIC KE" ).append("\n");
		query.append(", BKG_XPT_IMP_LIC BME" ).append("\n");
		query.append("WHERE KE.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND KE.BKG_NO = BME.BKG_NO(+)" ).append("\n");
		query.append("AND KE.CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND KE.DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("GROUP BY KE.XPT_LIC_NO" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}