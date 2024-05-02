/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.27
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchEmptyBlCntr
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n");
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL").append("\n");
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
		query.append("RPAD(CNTR_NO,12,' ') CNTR_NO," ).append("\n");
		query.append("RPAD(NVL(CNTR_SEAL_NO,' '),15,' ') CNTR_SEAL_NO," ).append("\n");
		query.append("RPAD(' ',15,' ') DATA1, --75 Seal No." ).append("\n");
		query.append("RPAD(' ',15,' ') DATA2, --75 Seal No." ).append("\n");
		query.append("RPAD(' ',15,' ') DATA3,	--75 Seal No." ).append("\n");
		query.append("RPAD(' ',15,' ') DATA4,	--75 Seal No." ).append("\n");
		query.append("RPAD(' ',15,' ') DATA5,	--75 Seal No." ).append("\n");
		query.append("'4  ' DATA6, --76 Empty/Full 컨테이너 표시  (3)   M" ).append("\n");
		query.append("DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2','22','3','25','4','42','5','45','6','92','7','95','8','92','9','95','95') DATA7, --77 콘테나사이즈코도  (2)   M" ).append("\n");
		query.append("DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'D','GP','R','RT','O','UT','S','UT','F','PF','A','PF','P','PF','T','TN','GP') DATA8, --78 콘테나타이푸코도  (2)   M" ).append("\n");
		query.append("'  ' DATA9, --79 DEL Term  (2)   C" ).append("\n");
		query.append("'2  ' DATA10, --80 컨테이너 소유 형태 코드  (3)   M" ).append("\n");
		query.append("'   ' DATA11, --81 밴닝 형태 코드  (3)   C" ).append("\n");
		query.append("'1' DATA12, --82 컨테이너 조약적용 식별  (1)   M" ).append("\n");
		query.append("' ' DATA13 	--83 도매 컨테이너 자동추출 대상외 식별  (1)   C" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CSTMS_JP_BL_CNTR" ).append("\n");
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n");
		query.append("AND	BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n");
		query.append("AND JP_CSTMS_CNTR_STS_CD = 'A'" ).append("\n");

	}
}