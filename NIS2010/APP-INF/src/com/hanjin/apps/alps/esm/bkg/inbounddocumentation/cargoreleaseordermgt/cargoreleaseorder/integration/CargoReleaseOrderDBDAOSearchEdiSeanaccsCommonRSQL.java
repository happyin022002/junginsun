/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonRSQL(){
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
		params.put("usr_pwd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsCommonRSQL").append("\n"); 
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
		query.append("	   SELECT (SELECT SUM(LENGTH(RPAD(DECODE(NVL(B.BL_NO,' '),' ',' ','SMLM'||B.BL_NO),35,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||RPAD(NVL(NVL(C.JP_DO_ID,C.DO_NO),' '),10,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||RPAD(NVL(NVL(D.CY_OP_CD,E.CY_OPR_ID),' '),5,' ')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10)" ).append("\n"); 
		query.append("                                    ||DECODE( NVL(D.INFO_CGO_FLG,' '), 'N',' ','Y')" ).append("\n"); 
		query.append("                                    ||CHR(13)" ).append("\n"); 
		query.append("                                    ||CHR(10) )) LEN_1" ).append("\n"); 
		query.append("                  FROM   BKG_JP_DO_IF   A" ).append("\n"); 
		query.append("                       , BKG_BOOKING    B" ).append("\n"); 
		query.append("                       , BKG_DO         C" ).append("\n"); 
		query.append("                       , BKG_DO_REF     D" ).append("\n"); 
		query.append("                       ,BKG_CSTMS_JP_BL E" ).append("\n"); 
		query.append("                  WHERE A.JP_DO_GRP_NO     = @[grp_no] -- 전송 대상 그룹핑으로 묶인 B/L" ).append("\n"); 
		query.append("                  AND   A.JP_DO_SND_STS_CD = 'T'" ).append("\n"); 
		query.append("                  AND   B.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("                  AND   C.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("                  AND   D.BKG_NO(+)        = A.BKG_NO" ).append("\n"); 
		query.append("                  AND   E.BL_NO(+)         = A.BKG_NO)    AS LEN_1" ).append("\n"); 
		query.append("               ,(SELECT NVL(@[evnt_cd],' ')||CHR(13)||CHR(10)||    --  '1' 등록" ).append("\n"); 
		query.append("                        LPAD(' ',5,' ')||CHR(13)||CHR(10) AS LEN2" ).append("\n"); 
		query.append("                 FROM DUAL ) AS LEN_2" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append(") SUB_1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}