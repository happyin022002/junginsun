/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchIBTransTypeChgRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier :
*@LastVersion : 1.0
* 2011.03.08
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchIBTransTypeChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * --WHF/CTT Exception Check(Inbound)
	  * --T/S로 인한 WHF/CTT 면제시 kcd_tp을 'T'로 바꿔준다
	  * --BRH_WHF_IND = 'X' 하나만 check해도 ok
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchIBTransTypeChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchIBTransTypeChgRSQL").append("\n");
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
		query.append("SELECT DISTINCT KR.CSTMS_DECL_TP_CD TRANS_TYPE" ).append("\n");
		query.append("     , DECODE(RATE.BKG_RT_WHF_EXPT_CD,'X','T') TRANS_TYPE_CHG" ).append("\n");
		query.append("FROM   BKG_CSTMS_ADV_KR_BL KR, BKG_RATE RATE" ).append("\n");
		query.append("WHERE  KR.BKG_NO = RATE.BKG_NO(+)" ).append("\n");
		query.append("AND    KR.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    KR.CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n");
		query.append("AND    KR.DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND    KR.TRNS_SEQ = @[kt_seq]" ).append("\n");
		query.append("AND    DECODE(@[in_bound],'I',DECODE(LENGTH(@[pod_tml]),7,KR.PORT_TML_CD,' '),' ') " ).append("\n");
		query.append("       = DECODE(@[in_bound],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");

	}
}