/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchMrnCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.10.28
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

public class KorCustomsTransmissionDBDAOsearchMrnCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 동일 MRN NO가 존재하는 지 체크한다
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchMrnCheckRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOsearchMrnCheckRSQL").append("\n");
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
		query.append("SELECT MRN_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n");
		query.append("WHERE MRN_NO = @[mrn_no]" ).append("\n");
		query.append("MINUS" ).append("\n");
		query.append("SELECT MRN_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n");
		query.append("WHERE MRN_NO = @[mrn_no]" ).append("\n");
		query.append("AND   VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND   PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND   IO_BND_CD = @[io_bnd_cd]" ).append("\n");

	}
}