/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchObTransTpExpWhfRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.02 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchObTransTpExpWhfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Trans Type 조회하고 WHF/CTT Exception Check(Outbound)한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchObTransTpExpWhfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchObTransTpExpWhfRSQL").append("\n");
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
		query.append("SELECT KOR.CSTMS_DECL_TP_CD TRANS_TYPE, DECODE(RATE.BKG_RT_WHF_EXPT_CD,'X','R') EXPT_KCD_TP" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL KOR, BKG_RATE RATE" ).append("\n");
		query.append("WHERE KOR.BKG_NO = RATE.BKG_NO" ).append("\n");
		query.append("AND KOR.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND KOR.CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND KOR.TRNS_SEQ = @[kt_seq]" ).append("\n");
		query.append("AND KOR.DMST_PORT_CD = @[kt_port]" ).append("\n");

	}
}