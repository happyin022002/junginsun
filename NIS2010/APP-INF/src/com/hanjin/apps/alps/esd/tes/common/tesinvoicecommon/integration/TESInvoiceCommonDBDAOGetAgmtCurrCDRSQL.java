/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.05 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (calc 계산시) agreement의 currency code를 가져온다.
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration ").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL").append("\n"); 
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
		query.append("SELECT	D.CURR_CD" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR H" ).append("\n"); 
		query.append(", TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("WHERE	H.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("AND		H.TML_AGMT_STS_CD	= 'C'" ).append("\n"); 
		query.append("AND		TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[from_date],'-')" ).append("\n"); 
		query.append("AND		TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_date],'-')" ).append("\n"); 
		query.append("AND		H.TML_AGMT_VER_NO = ( SELECT	MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("WHERE	M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("AND	M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("AND	M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("AND	TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[from_date],'-')" ).append("\n"); 
		query.append("AND	TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_date],'-'))" ).append("\n"); 
		query.append("AND		H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND		H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND		ROWNUM	= 1" ).append("\n"); 

	}
}