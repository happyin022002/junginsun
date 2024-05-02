/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.09 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Multi Seal No 의 flat file을 만들기 위함.
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL").append("\n");
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
		query.append("SELECT SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00000')||" ).append("\n");
		query.append("CNTR_SEAL_NO1||'~'||" ).append("\n");
		query.append("CNTR_SEAL_NO2" ).append("\n");
		query.append("), 7) SEAL_NUMBERS" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_CNTR" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD =  @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND DMST_PORT_CD     =  @[port_cd]" ).append("\n");
		query.append("AND CNTR_NO =  @[cntr_no]" ).append("\n");
		query.append("GROUP BY CNTR_NO" ).append("\n");

	}
}