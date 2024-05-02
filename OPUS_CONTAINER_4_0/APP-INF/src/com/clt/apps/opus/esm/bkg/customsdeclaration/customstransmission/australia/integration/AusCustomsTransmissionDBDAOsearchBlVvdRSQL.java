/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchBlVvdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.02.23 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchBlVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchBlVvdRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchBlVvdRSQL").append("\n");
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
		query.append("SELECT	 " ).append("\n");
		query.append("		NVL(VSL_CD,'')||" ).append("\n");
		query.append("		NVL(SKD_VOY_NO,'')||NVL(SKD_DIR_CD,'') bvvd," ).append("\n");
		query.append("		NVL(pol_cd,'') bpol," ).append("\n");
		query.append("		NVL(pod_cd,'') bpod		 " ).append("\n");
		query.append("FROM	BKG_VVD" ).append("\n");
		query.append("WHERE	BKG_NO        = @[bkg_no]" ).append("\n");
		query.append("ORDER BY VSL_PRE_PST_CD" ).append("\n");

	}
}