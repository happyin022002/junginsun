/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Flat File Header 생성
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL").append("\n");
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
		query.append("SELECT '$$$MSGSTART:'||" ).append("\n");
		query.append("    RPAD(NVL(NVL(DECODE(@[pod_cd],'AUBNE','HSABNE','AUMEL','HSAMEL','AUSYD','HSASYD'),DECODE(@[pol_cd],'AUBNE','HSABNE','AUMEL','HSAMEL','AUSYD','HSASYD',COM_ConstantMgr_PKG.COM_getScacCode_FNC())),' '),20,' ')||" ).append("\n");
		query.append("    RPAD(NVL(NVL(DECODE(@[pod_cd],'AUBNE','BPC','AUMEL','MPC','AUSYD','SPC'),DECODE(@[pol_cd],'AUBNE','BPC','AUMEL','MPC','AUSYD','SPC','AUSCUS')),' '),20,' ')||" ).append("\n");
		query.append("    RPAD(NVL(NVL(DECODE(@[pod_cd],'AUBNE','IFCSUM','AUMEL','IFCSUM','AUSYD','IFCSUM'),DECODE(@[pol_cd],'AUBNE','IFCSUM','AUMEL','IFCSUM','AUSYD','IFCSUM','IFTMCS')),' '),10,' ')||" ).append("\n");
		query.append("    'BKC'||" ).append("\n");
		query.append("    TO_CHAR(sysdate,'rrmmdd')||" ).append("\n");
		query.append("			LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') msg_header	" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}