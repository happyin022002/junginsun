/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonByCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonByCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonByCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_pwd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonByCancelRSQL").append("\n"); 
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
		query.append("SELECT '   '||RPAD('DOR  ',5,' ')||" ).append("\n"); 
		query.append("       RPAD(' ',21,' ')||" ).append("\n"); 
		query.append("       @[usr_id]||" ).append("\n"); 
		query.append("       @[usr_pwd]||" ).append("\n"); 
		query.append("       RPAD(' ',174,' ')||" ).append("\n"); 
		query.append("       RPAD(' ',26,' ')||" ).append("\n"); 
		query.append("       RPAD(' ',8,' ')||" ).append("\n"); 
		query.append("       RPAD(UPPER(@[cre_usr_id]),10,' ')||" ).append("\n"); 
		query.append("       RPAD(' ',100,' ')||" ).append("\n"); 
		query.append("       RPAD(' ',1,' ')||" ).append("\n"); 
		query.append("       '2'||" ).append("\n"); 
		query.append("       RPAD(' ',27,' ')|| " ).append("\n"); 
		query.append("       LPAD((SUB_1.LEN_1 + length(SUB_1.LEN_2) + 400),6,'0')||CHR(13)||CHR(10)  /* 400 은 입력공통항목 자릿수 */" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	   SELECT (SELECT LENGTH(RPAD(DECODE(NVL(C.BL_NO,' '),' ',' ',COM_ConstantMgr_PKG.COM_getScacCode_FNC||C.BL_NO),35,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||RPAD(NVL(NVL(A.JP_DO_ID,A.DO_NO),' '),10,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||RPAD(NVL(NVL(B.CY_OP_CD,D.CY_OPR_ID),' '),5,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||DECODE( NVL(B.INFO_CGO_FLG,' '), 'N',' ','Y')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10) ) LEN_1" ).append("\n"); 
		query.append("                  FROM   BKG_DO          A" ).append("\n"); 
		query.append("                       , BKG_DO_REF      B" ).append("\n"); 
		query.append("                       , BKG_BOOKING     C" ).append("\n"); 
		query.append("                       , BKG_CSTMS_JP_BL D" ).append("\n"); 
		query.append("                  WHERE A.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("                  AND   A.RLSE_SEQ         = '1'" ).append("\n"); 
		query.append("                  AND   B.BKG_NO(+)        = A.BKG_NO" ).append("\n"); 
		query.append("                  AND   C.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("                  AND   D.BL_NO(+)         = C.BL_NO )    AS LEN_1" ).append("\n"); 
		query.append("               ,(SELECT NVL(@[evnt_cd],' ')||CHR(13)||CHR(10)||    --  '1' 등록" ).append("\n"); 
		query.append("                        LPAD(' ',5,' ')||CHR(13)||CHR(10) AS LEN2" ).append("\n"); 
		query.append("                 FROM DUAL ) AS LEN_2" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append(") SUB_1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}