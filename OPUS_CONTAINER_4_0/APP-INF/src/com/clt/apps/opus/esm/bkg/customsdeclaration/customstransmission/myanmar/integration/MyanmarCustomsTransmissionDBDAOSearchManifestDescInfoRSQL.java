/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchManifestDescInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier :
*@LastVersion : 1.0
* 2013.03.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchManifestDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchManifestDescInfo
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchManifestDescInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n");
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchManifestDescInfoRSQL").append("\n");
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
		query.append("SELECT PCK_CMDT_DESC  DESC1," ).append("\n");
		query.append("CNTR_CMDT_DESC||(SELECT DECODE(COUNT(*),0,'',', PART OF CONTAINER.') FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO AND CNTR_PRT_FLG = 'Y') DESC2," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 1) != 0 THEN SUBSTR(CMDT_DESC, 1, INSTR(CMDT_DESC, CHR(10), 1, 1)-1) ELSE SUBSTR(CMDT_DESC, 1) END DESC3," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 2) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 1)+2, INSTR(CMDT_DESC, CHR(10), 1, 2)-2-INSTR(CMDT_DESC, CHR(10), 1, 1)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 1) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 1)+2) ELSE null END END DESC4," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 3) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 2)+2, INSTR(CMDT_DESC, CHR(10), 1, 3)-2-INSTR(CMDT_DESC, CHR(10), 1, 2)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 2) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 2)+2) ELSE null END END DESC5," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 4) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 3)+2, INSTR(CMDT_DESC, CHR(10), 1, 4)-2-INSTR(CMDT_DESC, CHR(10), 1, 3)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 3) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 3)+2) ELSE null END END DESC6," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 5) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 4)+2, INSTR(CMDT_DESC, CHR(10), 1, 5)-2-INSTR(CMDT_DESC, CHR(10), 1, 4)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 4) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 4)+2) ELSE null END END DESC7," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 6) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 5)+2, INSTR(CMDT_DESC, CHR(10), 1, 6)-2-INSTR(CMDT_DESC, CHR(10), 1, 5)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 5) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 5)+2) ELSE null END END DESC8," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 7) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 6)+2, INSTR(CMDT_DESC, CHR(10), 1, 7)-2-INSTR(CMDT_DESC, CHR(10), 1, 6)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 6) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 6)+2) ELSE null END END DESC9," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 8) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 7)+2, INSTR(CMDT_DESC, CHR(10), 1, 8)-2-INSTR(CMDT_DESC, CHR(10), 1, 7)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 7) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 7)+2) ELSE null END END DESC10," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 9) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 8)+2, INSTR(CMDT_DESC, CHR(10), 1, 9)-2-INSTR(CMDT_DESC, CHR(10), 1, 8)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 8) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 8)+2) ELSE null END END DESC11," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 10) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 9)+2, INSTR(CMDT_DESC, CHR(10), 1, 10)-2-INSTR(CMDT_DESC, CHR(10), 1, 9)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 9) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 9)+2) ELSE null END END DESC12," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 11) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 10)+2, INSTR(CMDT_DESC, CHR(10), 1, 11)-2-INSTR(CMDT_DESC, CHR(10), 1, 10)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 10) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 10)+2) ELSE null END END DESC13," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 12) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 11)+2, INSTR(CMDT_DESC, CHR(10), 1, 12)-2-INSTR(CMDT_DESC, CHR(10), 1, 11)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 11) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 11)+2) ELSE null END END DESC14," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 13) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 12)+2, INSTR(CMDT_DESC, CHR(10), 1, 13)-2-INSTR(CMDT_DESC, CHR(10), 1, 12)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 12) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 12)+2) ELSE null END END DESC15," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 14) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 13)+2, INSTR(CMDT_DESC, CHR(10), 1, 14)-2-INSTR(CMDT_DESC, CHR(10), 1, 13)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 13) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 13)+2) ELSE null END END DESC16," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 15) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 14)+2, INSTR(CMDT_DESC, CHR(10), 1, 15)-2-INSTR(CMDT_DESC, CHR(10), 1, 14)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 14) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 14)+2) ELSE null END END DESC17," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 16) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 15)+2, INSTR(CMDT_DESC, CHR(10), 1, 16)-2-INSTR(CMDT_DESC, CHR(10), 1, 15)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 15) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 15)+2) ELSE null END END DESC18," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 17) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 16)+2, INSTR(CMDT_DESC, CHR(10), 1, 17)-2-INSTR(CMDT_DESC, CHR(10), 1, 16)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 16) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 16)+2) ELSE null END END DESC19," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 18) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 17)+2, INSTR(CMDT_DESC, CHR(10), 1, 18)-2-INSTR(CMDT_DESC, CHR(10), 1, 17)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 17) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 17)+2) ELSE null END END DESC20," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 19) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 18)+2, INSTR(CMDT_DESC, CHR(10), 1, 19)-2-INSTR(CMDT_DESC, CHR(10), 1, 18)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 18) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 18)+2) ELSE null END END DESC21," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 20) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 19)+2, INSTR(CMDT_DESC, CHR(10), 1, 20)-2-INSTR(CMDT_DESC, CHR(10), 1, 19)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 19) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 19)+2) ELSE null END END DESC22," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 21) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 20)+2, INSTR(CMDT_DESC, CHR(10), 1, 21)-2-INSTR(CMDT_DESC, CHR(10), 1, 20)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 20) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 20)+2) ELSE null END END DESC23," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 22) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 21)+2, INSTR(CMDT_DESC, CHR(10), 1, 22)-2-INSTR(CMDT_DESC, CHR(10), 1, 21)) ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 21) != 0 THEN SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 21)+2) ELSE null END END DESC24," ).append("\n");
		query.append("CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 23) != 0 THEN 'as per attached' ELSE CASE WHEN INSTR(CMDT_DESC, CHR(10), 1, 22) != 0 THEN TO_CHAR(SUBSTR(CMDT_DESC, INSTR(CMDT_DESC, CHR(10), 1, 22)+2)) ELSE null END END DESC25," ).append("\n");
		query.append("" ).append("\n");
		query.append("CASE WHEN C.ADDR_PRN_FLG = 'N' THEN '' ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 1) != 0 THEN SUBSTR(C.CUST_NM, 1, INSTR(C.CUST_NM, CHR(10), 1, 1)-1) ELSE SUBSTR(C.CUST_NM, 1) END END DESC26," ).append("\n");
		query.append("CASE WHEN C.ADDR_PRN_FLG = 'N' THEN '' ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 2) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 1)+2, INSTR(C.CUST_NM, CHR(10), 1, 2)-2-INSTR(C.CUST_NM, CHR(10), 1, 1)) ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 1) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 1)+2) ELSE null END END END DESC27," ).append("\n");
		query.append("CASE WHEN C.ADDR_PRN_FLG = 'N' THEN '' ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 3) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 2)+2, INSTR(C.CUST_NM, CHR(10), 1, 3)-2-INSTR(C.CUST_NM, CHR(10), 1, 2)) ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 2) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 2)+2) ELSE null END END END DESC28," ).append("\n");
		query.append("CASE WHEN C.ADDR_PRN_FLG = 'N' THEN '' ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 4) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 3)+2, INSTR(C.CUST_NM, CHR(10), 1, 4)-2-INSTR(C.CUST_NM, CHR(10), 1, 3)) ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 3) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 3)+2) ELSE null END END END DESC29," ).append("\n");
		query.append("CASE WHEN C.ADDR_PRN_FLG = 'N' THEN '' ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 5) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 4)+2, INSTR(C.CUST_NM, CHR(10), 1, 5)-2-INSTR(C.CUST_NM, CHR(10), 1, 4)) ELSE CASE WHEN INSTR(C.CUST_NM, CHR(10), 1, 4) != 0 THEN SUBSTR(C.CUST_NM, INSTR(C.CUST_NM, CHR(10), 1, 4)+2) ELSE null END END END DESC30" ).append("\n");
		query.append("FROM BKG_BL_MK_DESC A, BKG_BL_DOC B, BKG_CUSTOMER C" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("AND B.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("AND C.BKG_CUST_TP_CD(+) = 'A'" ).append("\n");

	}
}