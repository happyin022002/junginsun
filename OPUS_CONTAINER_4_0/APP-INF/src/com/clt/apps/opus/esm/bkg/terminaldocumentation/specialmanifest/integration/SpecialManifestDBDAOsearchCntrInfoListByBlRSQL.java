/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchCntrInfoListByBlRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchCntrInfoListByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 해당 Bl에 속한 컨테이너와 컨테이너 Cgo Seq 리스트 리스트를 조회한다.(콤보 셋팅을 위해)
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchCntrInfoListByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n");
		query.append("FileName : SpecialManifestDBDAOsearchCntrInfoListByBlRSQL").append("\n");
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
		query.append("SELECT DISTINCT CNTR_NO" ).append("\n");
		query.append("FROM BKG_CSTMS_EUR_DG" ).append("\n");
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("AND   PORT_CD     = @[port_cd]" ).append("\n");
		query.append("AND   BL_NO       = @[bl_no] -- 키 필드로 변경 예정" ).append("\n");
		query.append("AND   EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n");
		query.append("ORDER BY CNTR_NO" ).append("\n");

	}
}