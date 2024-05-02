/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchTeuFeuCntRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.10 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchTeuFeuCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG_CSTMS_KR_SND_LOG 테이블에 CNTR의 Type Size count정보를 남기기위해서 조회함.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchTeuFeuCntRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOsearchTeuFeuCntRSQL").append("\n");
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
		query.append("SELECT COUNT(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',CNTR_TPSZ_CD,NULL)) TEU_CNT" ).append("\n");
		query.append(", COUNT(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',NULL,CNTR_TPSZ_CD)) FEU_CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CNTR" ).append("\n");
		query.append("WHERE BKG_NO           =   @[bkg_no]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("AND CNTR_NO <> 'IN BULK'" ).append("\n");

	}
}