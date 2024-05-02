/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.12.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CUSMAN의 CNTR정보에 대한 Flat file을 만든다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(KC.CNTR_NO,'Y')  ||'~'|| /*  Export License No   */" ).append("\n");
		query.append("KC.FULL_MTY_CD     ||'~'|| /*  Package Unit        */" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(KC.CNTR_SEAL_NO1,'Y')  ||'~'|| /*  Package Count       */" ).append("\n");
		query.append("KC.CNTR_TPSZ_CD  ||'~'|| /*  Weight Unit         */" ).append("\n");
		query.append("PCK_QTY       ||'~'|| /*  Weight              */" ).append("\n");
		query.append("KC.PCK_TP_CD  ||'~'|| /*  분할선적 여부       */" ).append("\n");
		query.append("TRIM(TO_CHAR(REPLACE(KC.CNTR_WGT,',',''),'999999999999999.99'))||'~'|| /*  This E/L No         */" ).append("\n");
		query.append("KC.WGT_UT_CD  ||'~'|| /*  동시 포장 여부      */" ).append("\n");
		query.append("KC.MEAS_QTY   ||'~'|| /*  Unit Pakage Unit    */" ).append("\n");
		query.append("KC.MEAS_UT_CD ||'~'   /*  Unit Package Count  */" ).append("\n");
		query.append("CNTR_DATA" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_CNTR KC" ).append("\n");
		query.append("WHERE   KC.BKG_NO           =   @[bkg_no]" ).append("\n");
		query.append("AND     KC.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND     KC.DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("AND     KC.CSTMS_BL_NO 		=   @[c_bl_no]" ).append("\n");
		query.append("AND	    KC.TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO           = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND    DMST_PORT_CD     = @[port_cd]" ).append("\n");
		query.append("AND    VSL_CD           = substr(@[vvd], 1, 4)" ).append("\n");
		query.append("AND    SKD_VOY_NO       = substr(@[vvd], 5, 4)" ).append("\n");
		query.append("AND    SKD_DIR_CD       = substr(@[vvd], 9, 1))" ).append("\n");

	}
}